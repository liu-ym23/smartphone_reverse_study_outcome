package com.lynx.tasm.behavior.ui.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.RemoteException;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import i8a.h;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import x6a.d;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AndroidText extends com.lynx.tasm.behavior.ui.view.a implements ActionMode.Callback {
    private static final int DEFAULT_TEXT_HANDLE_COLOR = -16614661;
    private static final int DEFAULT_TEXT_HANDLE_SIZE = 15;
    private static final int DEFAULT_TEXT_SELECTION_COLOR = 1714664933;
    private static final int ID_COPY = 65534;
    private static final int ID_SELECT_ALL = 65533;
    private static final float RESPONSE_TOUCH_RADIUS = 50.0f;
    protected static final String SELECTION_CHANGE_EVENT = "selectionchange";
    private static WeakReference<AndroidText> sWeakSelectingAndroidText;
    private ActionMode mActionMode;
    private a mCheckForLongPress;
    private int mDefaultHandlePlatformLength;
    private boolean mDisplayNone;
    private boolean mEnableCustomContextMenu;
    private boolean mEnableCustomTextSelection;
    private boolean mEnableTextSelection;
    private final PointF mEndHandlerPos;
    private int mHandleSize;
    protected boolean mHasImage;
    private Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mIsAdjustEndPos;
    private boolean mIsAdjustStartPos;
    private boolean mIsBindSelectionChange;
    private boolean mIsForward;
    private boolean mIsInSelection;
    protected boolean mIsJustify;
    private boolean mIsShowEndHandle;
    private boolean mIsShowStartHandle;
    private int mLastSelectEnd;
    private int mLastSelectStart;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private int mOverflow;
    private Picture mOverflowPicture;
    private boolean mOverflowPictureDirty;
    private int mSelectEnd;
    private final PointF mSelectEndPos;
    private int mSelectStart;
    private final PointF mSelectStartPos;
    private Drawable mSelectionLeftCursor;
    private Drawable mSelectionRightCursor;
    private boolean mShouldResponseMove;
    private int mSign;
    private final PointF mStartHandlerPos;
    protected Layout mTextLayout;
    private int mTextSelectionColor;
    private int mTextSelectionHandleColor;
    private final ArrayList<RectF> mTextServiceSelectionBoxes;
    private int mTextServiceSelectionEnd;
    private int mTextServiceSelectionStart;
    private int mTextServiceTextLength;
    protected PointF mTextTranslateOffset;
    protected w mTextUpdateBundle;
    protected ILynxTextService.a mTextraPage;

    public final class a implements Runnable {
        public final float a;
        public final float b;
        public final /* synthetic */ AndroidText c;

        public final void a() {
            int r0 = AndroidText.access$000(this.c, this.a, this.b);
            if (r0 >= 0) goto L6;
            AndroidText.access$102(this.c, null);
            return;
        L6:
            AndroidText.access$202(this.c, true);
            AndroidText.access$300(this.c).set(this.a, this.b);
            AndroidText.access$400(this.c).set(this.a, this.b);
            AndroidText r2 = this.c;
            AndroidText.access$502(r2, AndroidText.access$602(r2, r0));
            AndroidText.access$702(this.c, true);
            this.c.requestDisallowInterceptTouchEvent(true);
            AndroidText.access$102(this.c, null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AndroidText r1, float r2, float r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    private void resetSelectionState() {
        this.mLastSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mSelectEnd = -1;
        this.mSelectStart = -1;
        this.mShouldResponseMove = false;
        this.mIsAdjustEndPos = false;
        this.mIsAdjustStartPos = false;
        this.mIsInSelection = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        invalidateTextServiceSelectionBoxes();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        d.a(this, r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
        d.b(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
        d.c(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return d.d(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    public void setTextGradient(ReadableArray r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    private void clearOtherSelection() {
        if (this.mEnableCustomTextSelection == false) goto L5;
        return;
    L5:
        WeakReference<AndroidText> r0 = sWeakSelectingAndroidText;
        if (r0 == null) goto L11;
        AndroidText r1 = r0.get();
        if (r1 == null) goto L11;
        if (r1 == this) goto L11;
        r1.clearSelection();
        r1.invalidate();
    L11:
        sWeakSelectingAndroidText = new WeakReference(this);
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L7:
        if (r3 >= r2) goto L12;
        com.lynx.tasm.behavior.ui.text.a r4 = r1[r3];
        r4.f();
        r4.j(null);
        r3 = r3 + 1;
        goto L7
    L12:
        return;
    }

    private void drawOverflowPicture() {
        if (this.mOverflowPictureDirty == true) goto L5;
        return;
    L5:
        if (this.mTextLayout == null) goto L20;
        Picture r0 = this.mOverflowPicture;
        if (r0 != null) goto L10;
        this.mOverflowPicture = new Picture();
    L11:
        Canvas r1 = this.mOverflowPicture.beginRecording(this.mTextLayout.getWidth(), this.mTextLayout.getHeight());
        r1.save();
        if (getClipBounds() == null) goto L14;
        r1.clipRect(getClipBounds());
    L14:
        drawTextOnCanvas(r1);
        if (this.mNeedDrawStroke == false) goto L17;
        com.lynx.tasm.behavior.shadow.text.b.g(this.mTextLayout, r1);
    L17:
        r1.restore();
        this.mOverflowPicture.endRecording();
        this.mOverflowPictureDirty = false;
        return;
    L10:
        r0.endRecording();
        goto L11
    }

    private boolean hasTextSelectionContent() {
        if (this.mTextLayout == null) goto L5;
    L10:
        return true;
    L5:
        if (this.mTextraPage != null) goto L7;
    L9:
        return false;
    L7:
        if (this.mTextServiceTextLength <= 0) goto L9;
        goto L9
    }

    private void hideToolbar() {
        if (this.mEnableCustomContextMenu == true) goto L9;
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L10;
        r0.finish();
        this.mActionMode = null;
        return;
    L10:
        return;
    }

    private void invalidateTextServiceSelectionBoxes() {
        this.mTextServiceSelectionBoxes.clear();
        this.mTextServiceSelectionStart = -1;
        this.mTextServiceSelectionEnd = -1;
    }

    private void onSelectionChange() {
        if (this.mIsBindSelectionChange == true) goto L5;
        return;
    L5:
        if ((getContext() instanceof LynxContext) == false) goto L13;
        m7a.a r0 = new m7a.a(this.mSign, SELECTION_CHANGE_EVENT);
        r0.a("start", Integer.valueOf(this.mSelectStart));
        r0.a("end", Integer.valueOf(this.mSelectEnd));
        if (this.mIsForward == false) goto L9;
        String r1 = "forward";
    L10:
        r0.a("direction", r1);
        ((LynxContext) getContext()).getEventEmitter().sendCustomEvent(r0);
        return;
    L9:
        r1 = "backward";
        goto L10
    }

    private void performCopy() {
        if (this.mTextraPage == null) goto L7;
        String r0 = getSelectedText();
        if (r0.isEmpty() == true) goto L14;
        copyToClipboard(r0);
    L14:
        clearSelection();
        return;
    L7:
        int r1 = this.mSelectStart;
        if (r1 < 0) goto L14;
        int r2 = this.mSelectEnd;
        if (r2 <= r1) goto L14;
        if (r2 > this.mTextLayout.getText().length()) goto L14;
        copyToClipboard(this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd));
        goto L14
    }

    private void performSelectAll() {
        if (this.mTextraPage == null) goto L9;
        int r0 = this.mTextServiceTextLength;
        if (r0 > 0) goto L7;
        return;
    L7:
        updateSelectionRange(0, r0);
        updateSelectStartEnd();
        return;
    L9:
        updateSelectionRange(0, this.mTextLayout.getText().length());
        updateSelectStartEnd();
    }

    private void removeCheckLongPressCallback() {
        a r0 = this.mCheckForLongPress;
        if (r0 != null) goto L5;
        return;
    L5:
        removeCallbacks(r0);
        this.mCheckForLongPress = null;
    }

    private void showToolbar() {
        if (this.mEnableCustomContextMenu == false) goto L5;
        return;
    L5:
        if (hasTextSelectionContent() == true) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        startActionMode(this, 1);
        return;
    L10:
        startActionMode(this);
    }

    private void updateSelectStartEnd() {
        int r0 = Math.min(this.mSelectStart, this.mSelectEnd);
        this.mSelectEnd = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mSelectStart = r0;
        onSelectionChange();
        if (this.mTextraPage == null) goto L6;
        updateSelectionHandlePositionFromBoxes(this.mSelectStart, this.mSelectEnd);
        return;
    L6:
        this.mSelectStartPos.set(getBottomPositionForOffset(this.mSelectStart, true));
        this.mSelectEndPos.set(getBottomPositionForOffset(this.mSelectEnd, false));
    }

    private void updateSelectionStyle() {
        Drawable r0 = this.mSelectionLeftCursor;
        int r1 = this.mHandleSize;
        r0.setBounds(0, 0, r1, r1);
        Drawable r2 = this.mSelectionRightCursor;
        int r3 = this.mHandleSize;
        r2.setBounds(0, 0, r3, r3);
        this.mSelectionLeftCursor.setTint(this.mTextSelectionHandleColor);
        this.mSelectionRightCursor.setTint(this.mTextSelectionHandleColor);
        this.mHighlightPaint.setColor(this.mTextSelectionColor);
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (this.mIsInSelection == false) goto L5;
        ArrayList<Float> r2 = new ArrayList();
        r2.add(Float.valueOf(this.mStartHandlerPos.x));
        r2.add(Float.valueOf(this.mStartHandlerPos.y));
        r2.add(Float.valueOf(RESPONSE_TOUCH_RADIUS));
        ArrayList<Float> r1 = new ArrayList();
        r1.add(Float.valueOf(this.mEndHandlerPos.x));
        r1.add(Float.valueOf(this.mEndHandlerPos.y));
        r1.add(Float.valueOf(RESPONSE_TOUCH_RADIUS));
        return new ArrayList[]{r2, r1};
    L5:
        return new ArrayList[0];
    }

    public String getSelectedText() {
        ILynxTextService.a r0 = this.mTextraPage;
        if (r0 == null) goto L10;
        int r1 = this.mSelectStart;
        if (r1 < 0) goto L10;
        int r2 = this.mSelectEnd;
        if (r2 <= r1) goto L10;
        return r0.b(r1, r2);
    L10:
        Layout r3 = this.mTextLayout;
        if (r3 == null) goto L21;
        int r4 = this.mSelectStart;
        if (r4 < 0) goto L23;
        int r5 = this.mSelectEnd;
        if (r5 <= 0) goto L24;
        if (r5 > r4) goto L18;
        return NameKeys.UnloadStrategy_No_Strategy;
    L18:
        if (r5 <= r3.getText().length()) goto L20;
        return NameKeys.UnloadStrategy_No_Strategy;
    L20:
        return this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd).toString();
    L24:
        return NameKeys.UnloadStrategy_No_Strategy;
    L23:
        return NameKeys.UnloadStrategy_No_Strategy;
    L21:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public CharSequence getText() {
        Layout r0 = this.mTextLayout;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    public boolean hasTextraPage() {
        if (this.mTextraPage == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), null);
        return;
    }

    private void clearSelection() {
        removeCheckLongPressCallback();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        invalidateTextServiceSelectionBoxes();
        if (this.mIsInSelection == false) goto L5;
        onSelectionChange();
    L5:
        this.mIsInSelection = false;
        updateSelectionRange(this.mSelectStart, this.mSelectEnd);
        hideToolbar();
        this.mShouldResponseMove = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        Path r0 = this.mHighlightPath;
        if (r0 == null) goto L9;
        r0.reset();
        return;
    }

    private float getTextDrawOffsetX() {
        float r0 = getPaddingLeft();
        PointF r1 = this.mTextTranslateOffset;
        if (r1 == null) goto L5;
        float r2 = r1.x;
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private float getTextDrawOffsetY() {
        float r0 = getPaddingTop();
        PointF r1 = this.mTextTranslateOffset;
        if (r1 == null) goto L5;
        float r2 = r1.y;
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispatchDetachImageSpan();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L7:
        if (r3 >= r2) goto L12;
        r1[r3].g();
        r3 = r3 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L7:
        if (r3 >= r2) goto L12;
        r1[r3].h();
        r3 = r3 + 1;
        goto L7
    L12:
        return;
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public AndroidText(Context r7) {
        super(r7);
        this.mTextServiceTextLength = 0;
        this.mNeedDrawStroke = false;
        this.mIsBindSelectionChange = false;
        this.mSign = 0;
        this.mIsForward = true;
        this.mEnableTextSelection = false;
        this.mEnableCustomContextMenu = false;
        this.mEnableCustomTextSelection = false;
        this.mActionMode = null;
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        this.mSelectStartPos = new PointF(-1.0f, -1.0f);
        this.mSelectEndPos = new PointF(-1.0f, -1.0f);
        this.mStartHandlerPos = new PointF(-1.0f, -1.0f);
        this.mEndHandlerPos = new PointF(-1.0f, -1.0f);
        this.mIsInSelection = false;
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mCheckForLongPress = null;
        this.mShouldResponseMove = false;
        this.mIsShowStartHandle = true;
        this.mIsShowEndHandle = true;
        this.mDisplayNone = false;
        this.mTextServiceSelectionBoxes = new ArrayList();
        this.mTextServiceSelectionStart = -1;
        this.mTextServiceSelectionEnd = -1;
        this.mOverflowPicture = new Picture();
        this.mOverflow = 0;
        this.mOverflowPictureDirty = true;
        setFocusable(true);
        setWillNotDraw(false);
        this.mTextSelectionColor = DEFAULT_TEXT_SELECTION_COLOR;
        this.mTextSelectionHandleColor = DEFAULT_TEXT_HANDLE_COLOR;
        int r8 = Math.round(((LynxContext) r7).getScreenMetrics().density * 15.0f);
        this.mDefaultHandlePlatformLength = r8;
        this.mHandleSize = r8;
    }

    public static /* synthetic */ PointF access$300(AndroidText r0) {
        return r0.mSelectStartPos;
    }

    public static /* synthetic */ PointF access$400(AndroidText r0) {
        return r0.mSelectEndPos;
    }

    private void copyToClipboard(CharSequence r3) {
        ClipData r4 = ClipData.newPlainText("Lynx-clipboard", r3);
        h r0 = (h) n.c().a(h.class);
        if (r0 == null) goto L9;
        r0.a(r4);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        LLog.e("AndroidText", "A RemoteException was encountered while calling systemInvokeService. " + e.getMessage());
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        ClipboardManager r1 = (ClipboardManager) getContext().getSystemService(ClipboardManager.class);
    L12:
        INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_text_AndroidText_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(r1, r4);
        return;
    L11:
        r1 = (ClipboardManager) getContext().getSystemService("clipboard");
        goto L12
    }

    private void drawHighlight(Canvas r5) {
        if (this.mIsInSelection == true) goto L5;
        return;
    L5:
        if (this.mHighlightPath != null) goto L7;
        return;
    L7:
        if (this.mHighlightPaint == null) goto L26;
        int r0 = Math.min(this.mSelectStart, this.mSelectEnd);
        int r1 = Math.max(this.mSelectStart, this.mSelectEnd);
        if (this.mTextraPage == null) goto L16;
        ArrayList<RectF> r2 = getTextServiceSelectionBoxes(r0, r1);
        int r3 = 0;
    L13:
        if (r3 >= r2.size()) goto L27;
        r5.drawRect((RectF) ListProtector.get(r2, r3), this.mHighlightPaint);
        r3 = r3 + 1;
        goto L13
    L27:
        return;
    L16:
        if (this.mTextLayout == null) goto L24;
        this.mHighlightPath.reset();
        this.mTextLayout.getSelectionPath(r0, r1, this.mHighlightPath);
        if (this.mHighlightPath.isEmpty() == true) goto L25;
        r5.drawPath(this.mHighlightPath, this.mHighlightPaint);
        return;
    L25:
        return;
    L24:
        return;
    }

    private void drawHighlightWithTextOffset(Canvas r3) {
        r3.save();
        r3.translate(getTextDrawOffsetX(), getTextDrawOffsetY());
        drawHighlight(r3);
        r3.restore();
    }

    private void drawSelectEndCursor(Canvas r5) {
        r5.save();
        r5.translate(this.mEndHandlerPos.x - (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mEndHandlerPos.y - (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        this.mSelectionRightCursor.draw(r5);
        r5.restore();
    }

    private void drawSelectHandle(Canvas r2) {
        if (this.mIsShowStartHandle == false) goto L6;
        drawSelectStartCursor(r2);
    L6:
        if (this.mIsShowEndHandle == false) goto L9;
        drawSelectEndCursor(r2);
        return;
    }

    private void drawSelectStartCursor(Canvas r5) {
        r5.save();
        r5.translate(this.mStartHandlerPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mStartHandlerPos.y - (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mSelectionLeftCursor.draw(r5);
        r5.restore();
    }

    private void drawText(Canvas r2) {
        drawHighlight(r2);
        drawTextOnCanvas(r2);
        if (this.mNeedDrawStroke == false) goto L5;
        com.lynx.tasm.behavior.shadow.text.b.g(this.mTextLayout, r2);
    L5:
        com.lynx.tasm.behavior.shadow.text.b.e(r2, this.mTextLayout);
    }

    private void drawTextOnCanvas(Canvas r4) {
        if (this.mIsJustify == true) goto L5;
    L7:
        this.mTextLayout.draw(r4);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        com.lynx.tasm.behavior.shadow.text.b.f(r4, this.mTextLayout, (getWidth() - getPaddingLeft()) - getPaddingRight());
    }

    private void drawTextServiceSelectHandle(Canvas r3) {
        if (this.mIsInSelection == true) goto L5;
        return;
    L5:
        if (this.mSelectionLeftCursor != null) goto L7;
        return;
    L7:
        if (this.mSelectionRightCursor == null) goto L13;
        r3.save();
        r3.translate(getTextDrawOffsetX(), getTextDrawOffsetY());
        drawSelectHandle(r3);
        r3.restore();
        return;
    }

    private PointF getCenterPositionForOffset(int r5) {
        if (r5 < 0) goto L9;
        if (r5 > this.mTextLayout.getText().length()) goto L9;
        int r0 = this.mTextLayout.getLineForOffset(r5);
        return new PointF(this.mTextLayout.getPrimaryHorizontal(r5), (this.mTextLayout.getLineTop(r0) + this.mTextLayout.getLineBottom(r0)) / 2.0f);
    L9:
        return new PointF(0.0f, 0.0f);
    }

    private int getLineAtCoordinate(float r2) {
        return this.mTextLayout.getLineForVertical((int) Math.min(getHeight() - 1, Math.max(0.0f, r2)));
    }

    private void initSelectionCursor(Context r3) {
        this.mSelectionLeftCursor = r3.getResources().getDrawable(2131243896);
        this.mSelectionRightCursor = r3.getResources().getDrawable(2131243897);
        Paint r4 = new Paint();
        this.mHighlightPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        this.mHighlightPath = new Path();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (this.mDisplayNone == false) goto L5;
        return;
    L5:
        super.dispatchDraw(r4);
        if (this.mTextraPage == null) goto L10;
        drawTextServiceSelectHandle(r4);
        return;
    L10:
        if (super.getRenderer() == null) goto L13;
        return;
    L13:
        if (this.mIsInSelection == false) goto L21;
        Path r0 = this.mHighlightPath;
        if (r0 != null) goto L17;
        return;
    L17:
        if (r0.isEmpty() == true) goto L23;
        r4.save();
        r4.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        drawSelectHandle(r4);
        r4.restore();
        return;
    L23:
        return;
    }

    public Layout generateTextLayout(w r1) {
        return r1.c;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r5) {
        if (UIThreadUtils.isOnUiThread() == true) goto L6;
        return;
    L6:
        if (this.mTextraPage != null) goto L21;
        if (r5 == null) goto L21;
        if (this.mHasImage == true) goto L12;
    L19:
        super.invalidateDrawable(r5);
        return;
    L12:
        if ((getText() instanceof Spanned) == false) goto L19;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L14:
        if (r3 >= r2) goto L19;
        if (r1[r3].c() != r5) goto L18;
        invalidate();
        this.mOverflowPictureDirty = true;
    L18:
        r3 = r3 + 1;
    L21:
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public void onDraw(Canvas r6) {
        if (this.mDisplayNone == false) goto L6;
        return;
    L6:
        if (super.getRenderer() == null) goto L12;
        super.getRenderer().g(r6);
        if (this.mTextraPage == null) goto L26;
        drawHighlightWithTextOffset(r6);
        return;
    L26:
        return;
    L12:
        if (this.mTextraPage == null) goto L19;
        int r0 = getPaddingLeft();
        int r1 = getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = getPaddingBottom();
        r6.save();
        if (this.mOverflow != 0) goto L16;
        r6.clipRect(r0, r2, getWidth() - r1, getHeight() - r3);
    L16:
        r6.translate(r0, r2);
        drawHighlight(r6);
        this.mTextraPage.d(r6, this);
        r6.restore();
        return;
    L19:
        if (this.mTextLayout == null) goto L27;
        r6.save();
        r6.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        if (this.mOverflow == 0) goto L23;
        drawHighlight(r6);
        drawOverflowPicture();
        r6.drawPicture(this.mOverflowPicture);
    L24:
        r6.restore();
        return;
    L23:
        drawText(r6);
        goto L24
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (hasTextSelectionContent() == false) goto L25;
        if (this.mEnableTextSelection == false) goto L25;
        if (this.mEnableCustomTextSelection == true) goto L25;
        float r0 = r6.getX() - getPaddingLeft();
        float r1 = r6.getY() - getPaddingTop();
        if (r6.getAction() != 0) goto L13;
        performBeginSelection(r0, r1);
    L22:
        invalidate();
        return true;
    L13:
        if (r6.getAction() != 2) goto L16;
        performMovingSelection(r0, r1);
        goto L22
    L16:
        if (r6.getAction() != 1) goto L19;
        performEndSelection(r0, r1);
        goto L22
    L19:
        if (this.mShouldResponseMove == false) goto L21;
        performEndSelection(r0, r1);
        goto L22
    L21:
        removeCheckLongPressCallback();
    L25:
        return super.onTouchEvent(r6);
    }

    public void setCustomContextMenu(boolean r1) {
        this.mEnableCustomContextMenu = r1;
    }

    public void setCustomTextSelection(boolean r1) {
        this.mEnableCustomTextSelection = r1;
    }

    public void setDisplayNone(boolean r1) {
        this.mDisplayNone = r1;
    }

    public void setEnableTextSelection(boolean r1) {
        this.mEnableTextSelection = r1;
    }

    public void setOverflow(int r1) {
        this.mOverflow = r1;
    }

    public void setTextBundle(w r3) {
        dispatchDetachImageSpan();
        this.mTextraPage = null;
        this.mTextServiceTextLength = 0;
        this.mTextUpdateBundle = r3;
        this.mTextLayout = generateTextLayout(r3);
        this.mTextTranslateOffset = r3.e;
        boolean r0 = r3.a;
        this.mHasImage = r0;
        this.mNeedDrawStroke = r3.f;
        this.mIsJustify = r3.b;
        this.mOriginText = r3.g;
        if (r0 == false) goto L8;
        if ((getText() instanceof Spanned) == false) goto L8;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), this);
    L8:
        if (this.mIsInSelection == false) goto L10;
        clearSelection();
    L11:
        setContentDescription(this.mTextLayout.getText());
        invalidate();
        this.mOverflowPictureDirty = true;
        return;
    L10:
        resetSelectionState();
        goto L11
    }

    public void setTextGradient(String r2) {
        LLog.e("text-gradient", "setTextGradient(String) is deprecated, call this function has no effect");
    }

    public void updateSelectionBackgroundColor(int r1) {
        if (r1 != 0) goto L4;
        r1 = DEFAULT_TEXT_SELECTION_COLOR;
    L4:
        this.mTextSelectionColor = r1;
    }

    public void updateSelectionHandleColor(int r1) {
        if (r1 != 0) goto L4;
        r1 = DEFAULT_TEXT_HANDLE_COLOR;
    L4:
        this.mTextSelectionHandleColor = r1;
    }

    public void updateSelectionHandleSize(int r1) {
        if (r1 > 0) goto L4;
        r1 = this.mDefaultHandlePlatformLength;
    L4:
        this.mHandleSize = r1;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (this.mHasImage == false) goto L14;
        if ((getText() instanceof Spanned) == false) goto L14;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L7:
        if (r3 >= r2) goto L14;
        if (r1[r3].c() == r5) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    L14:
        return super.verifyDrawable(r5);
    }

    public void setTextBundle(ILynxTextService.a r3) {
        dispatchDetachImageSpan();
        this.mTextraPage = r3;
        if (r3 == null) goto L5;
        int r4 = r3.a();
    L6:
        this.mTextServiceTextLength = r4;
        this.mTextUpdateBundle = null;
        this.mTextLayout = null;
        this.mTextTranslateOffset = new PointF();
        this.mHasImage = false;
        this.mNeedDrawStroke = false;
        this.mIsJustify = false;
        this.mOriginText = null;
        if (this.mIsInSelection == false) goto L9;
        clearSelection();
    L10:
        setContentDescription(null);
        invalidate();
        this.mOverflowPictureDirty = true;
        return;
    L9:
        resetSelectionState();
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_text_AndroidText_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(ClipboardManager r3, ClipData r4) {
        Intrinsics.checkNotNullParameter(r4, "clip");
        FLogger.a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        com_lynx_tasm_behavior_ui_text_AndroidText_android_content_ClipboardManager_setPrimaryClip(r3, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g.a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static /* synthetic */ a access$102(AndroidText r0, a r1) {
        r0.mCheckForLongPress = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(AndroidText r0, boolean r1) {
        r0.mIsInSelection = r1;
        return r1;
    }

    public static /* synthetic */ int access$502(AndroidText r0, int r1) {
        r0.mSelectEnd = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(AndroidText r0, int r1) {
        r0.mSelectStart = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$702(AndroidText r0, boolean r1) {
        r0.mIsAdjustEndPos = r1;
        return r1;
    }

    private void adjustEndPosition(float r2, float r3) {
        this.mIsAdjustEndPos = true;
        int r4 = getOffsetForPosition(r2, r3);
        if (r4 >= 0) goto L6;
        return;
    L6:
        if (r4 == this.mSelectStart) goto L8;
    L16:
        updateSelectionRange(this.mSelectStart, r4);
        return;
    L8:
        if (this.mTextraPage != null) goto L12;
        if (r4 != this.mTextLayout.getText().length()) goto L12;
    L14:
        r4 = r4 - 1;
    L12:
        if (r2 >= this.mSelectStartPos.x) goto L15;
        if (r4 > 0) goto L14;
    L15:
        r4 = r4 + 1;
        goto L16
    }

    private void adjustStartPosition(float r2, float r3) {
        this.mIsAdjustStartPos = true;
        int r4 = getOffsetForPosition(r2, r3);
        if (r4 >= 0) goto L6;
        return;
    L6:
        if (this.mSelectEnd == r4) goto L8;
    L16:
        updateSelectionRange(r4, this.mSelectEnd);
        return;
    L8:
        if (this.mTextraPage != null) goto L12;
        if (r4 != this.mTextLayout.getText().length()) goto L12;
    L14:
        r4 = r4 - 1;
    L12:
        if (r2 >= this.mSelectEndPos.x) goto L15;
        if (r4 > 0) goto L14;
    L15:
        r4 = r4 + 1;
        goto L16
    }

    private static void com_lynx_tasm_behavior_ui_text_AndroidText_android_content_ClipboardManager_setPrimaryClip(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private PointF getBottomPositionForOffset(int r5, boolean r6) {
        float r0 = this.mTextLayout.getPrimaryHorizontal(r5);
        int r1 = this.mTextLayout.getLineForOffset(r5);
        float r2 = this.mTextLayout.getLineBottom(r1);
        if (r5 != this.mTextLayout.getLineStart(r1)) goto L8;
        if (r1 <= 0) goto L8;
        if (r6 == true) goto L8;
        r0 = this.mTextLayout.getWidth();
        r2 = this.mTextLayout.getLineBottom(r1 - 1);
    L8:
        return new PointF(r0, r2);
    }

    private int getOffsetAtCoordinate(int r11, float r12) {
        int r0 = this.mTextLayout.getOffsetForHorizontal(r11, Math.min(getWidth() - 1, Math.max(0.0f, r12)));
        float r1 = this.mTextLayout.getSecondaryHorizontal(r0);
        if (r12 > (((double) r1) + (((double) (this.mTextLayout.getLineRight(r11) - r1)) / 2.0d))) goto L5;
        return r0;
    L5:
        return this.mTextLayout.getLineEnd(r11);
    }

    private int getOffsetForPosition(float r2, float r3) {
        ILynxTextService.a r0 = this.mTextraPage;
        if (r0 == null) goto L7;
        return r0.f(r2, r3);
    L7:
        if (this.mTextLayout != null) goto L11;
        return -1;
    L11:
        return getOffsetAtCoordinate(getLineAtCoordinate(r3), r2);
    }

    private ArrayList<RectF> getTextServiceSelectionBoxes(int r7, int r8) {
        if (r7 > r8) goto L26;
        if (r7 < 0) goto L26;
        if (this.mTextraPage == null) goto L26;
        if (this.mTextServiceSelectionStart == r7) goto L10;
    L13:
        this.mTextServiceSelectionBoxes.clear();
        this.mTextServiceSelectionStart = r7;
        this.mTextServiceSelectionEnd = r8;
        float[] r9 = this.mTextraPage.c(r7, r8);
        if (r9 == null) goto L25;
        if ((r9.length % 4) != 0) goto L25;
        int r10 = 0;
    L20:
        if (r10 >= r9.length) goto L23;
        ArrayList<RectF> r0 = this.mTextServiceSelectionBoxes;
        float r2 = r9[r10];
        float r3 = r9[r10 + 1];
        r0.add(new RectF(r2, r3, r9[r10 + 2] + r2, r9[r10 + 3] + r3));
        r10 = r10 + 4;
        goto L20
    L23:
        return this.mTextServiceSelectionBoxes;
    L25:
        return this.mTextServiceSelectionBoxes;
    L10:
        if (this.mTextServiceSelectionEnd != r8) goto L13;
        return this.mTextServiceSelectionBoxes;
    L26:
        invalidateTextServiceSelectionBoxes();
        return this.mTextServiceSelectionBoxes;
    }

    private void performBeginSelection(float r7, float r8) {
        hideToolbar();
        if (this.mIsInSelection == false) goto L12;
        this.mShouldResponseMove = true;
        if (distanceBetweenPoints(this.mStartHandlerPos, r7, r8) >= 50.0d) goto L8;
        adjustStartPosition(r7, r8);
        requestDisallowInterceptTouchEvent(true);
        goto L12
    L8:
        if (distanceBetweenPoints(this.mEndHandlerPos, r7, r8) >= 50.0d) goto L10;
        adjustEndPosition(r7, r8);
        requestDisallowInterceptTouchEvent(true);
        goto L12
    L10:
        this.mShouldResponseMove = false;
    L12:
        if (this.mIsAdjustEndPos == false) goto L14;
        return;
    L14:
        if (this.mIsAdjustStartPos == true) goto L18;
        removeCheckLongPressCallback();
        a r0 = new a(this, r7, r8);
        this.mCheckForLongPress = r0;
        postDelayed(r0, ViewConfiguration.getLongPressTimeout());
        return;
    }

    private void performEndSelection(float r4, float r5) {
        requestDisallowInterceptTouchEvent(false);
        if (this.mIsInSelection == true) goto L6;
        removeCheckLongPressCallback();
        return;
    L6:
        boolean r1 = this.mIsAdjustEndPos;
        if (r1 == true) goto L13;
        if (this.mIsAdjustStartPos == true) goto L13;
        clearSelection();
        return;
    L13:
        if (this.mIsAdjustStartPos == false) goto L15;
        adjustStartPosition(r4, r5);
        updateSelectStartEnd();
    L17:
        showToolbar();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        return;
    L15:
        if (r1 == false) goto L17;
        adjustEndPosition(r4, r5);
        updateSelectStartEnd();
        goto L17
    }

    private void performMovingSelection(float r3, float r4) {
        a r0 = this.mCheckForLongPress;
        if (r0 == null) goto L10;
        if (Math.abs(r3 - r0.a) <= 1.0f) goto L7;
    L8:
        removeCheckLongPressCallback();
        goto L10
    L7:
        if (Math.abs(r4 - this.mCheckForLongPress.b) > 1.0f) goto L8;
    L10:
        if (this.mIsAdjustStartPos == false) goto L13;
        adjustStartPosition(r3, r4);
        return;
    L13:
        if (this.mIsAdjustEndPos == false) goto L17;
        adjustEndPosition(r3, r4);
        return;
    }

    private void updateSelectionHandlePositionFromBoxes(int r4, int r5) {
        if (this.mTextraPage == null) goto L5;
        ArrayList<RectF> r6 = getTextServiceSelectionBoxes(r4, r5);
    L7:
        if (r6.isEmpty() == false) goto L9;
        return;
    L9:
        RectF r7 = (RectF) ListProtector.get(r6, 0);
        RectF r8 = (RectF) ListProtector.get(r6, r6.size() - 1);
        this.mSelectStartPos.set(r7.left, r7.bottom);
        this.mSelectEndPos.set(r8.right, r8.bottom);
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        return;
    L5:
        r6 = getTextBoundingBoxes(r4, r5);
        goto L7
    }

    private void updateSelectionRange(int r5, int r6) {
        if (this.mSelectionLeftCursor != null) goto L5;
        initSelectionCursor(getContext());
    L5:
        updateSelectionStyle();
        int r0 = this.mLastSelectStart;
        if (r0 != (-1)) goto L10;
        if (r6 > r5) goto L13;
    L9:
        boolean r1 = false;
    L14:
        this.mIsForward = r1;
        this.mLastSelectStart = this.mSelectStart;
        this.mLastSelectEnd = this.mSelectEnd;
        this.mSelectStart = r5;
        this.mSelectEnd = r6;
        if (this.mTextraPage == null) goto L20;
        if (r5 < 0) goto L35;
        if (r6 < 0) goto L36;
        updateSelectionHandlePositionFromBoxes(Math.min(r5, r6), Math.max(this.mSelectStart, this.mSelectEnd));
        clearOtherSelection();
        return;
    L36:
        return;
    L35:
        return;
    L20:
        if (r5 < 0) goto L32;
        if (r5 > this.mTextLayout.getText().length()) goto L32;
        int r7 = this.mSelectEnd;
        if (r7 < 0) goto L32;
        if (r7 > this.mTextLayout.getText().length()) goto L32;
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L30;
        Selection.setSelection((Spannable) this.mTextLayout.getText(), Math.min(this.mSelectStart, this.mSelectEnd), Math.max(this.mSelectStart, this.mSelectEnd));
    L30:
        this.mSelectStartPos.set(getBottomPositionForOffset(Math.min(this.mSelectStart, this.mSelectEnd), true));
        this.mSelectEndPos.set(getBottomPositionForOffset(Math.max(this.mSelectStart, this.mSelectEnd), false));
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        clearOtherSelection();
        return;
    L32:
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L38;
        Selection.removeSelection((Spannable) this.mTextLayout.getText());
        return;
    L38:
        return;
    L13:
        r1 = true;
        goto L14
    L10:
        if (r0 < r5) goto L13;
        if (this.mLastSelectEnd >= r6) goto L9;
        goto L9
    }

    public ArrayList<RectF> getTextBoundingBoxes(int r9, int r10) {
        ArrayList<RectF> r0 = new ArrayList();
        if (r9 > r10) goto L24;
        if (r9 < 0) goto L24;
        if (this.mTextraPage != null) goto L9;
        Layout r1 = this.mTextLayout;
        if (r1 == null) goto L24;
        if (r1.getText().length() < r10) goto L24;
        if (r9 != r10) goto L17;
        int r11 = this.mTextLayout.getLineForOffset(r9);
        r0.add(new RectF(0.0f, 0.0f, 0.0f, this.mTextLayout.getLineBottom(r11) - this.mTextLayout.getLineTop(r11)));
        goto L24
    L17:
        int r2 = this.mTextLayout.getLineForOffset(r9);
        int r3 = this.mTextLayout.getLineForOffset(r10);
        int r4 = r2;
    L18:
        if (r4 > r3) goto L24;
        Rect r5 = new Rect();
        this.mTextLayout.getLineBounds(r4, r5);
        if (r4 == r2) goto L22;
        if (r4 == r3) goto L22;
    L23:
        float r6 = r5.left;
        PointF r7 = this.mTextTranslateOffset;
        float r8 = r7.x;
        r5.left = (int) (r6 - r8);
        r5.right = (int) (r5.right - r8);
        float r12 = r5.top;
        float r13 = r7.y;
        r5.top = (int) (r12 - r13);
        r5.bottom = (int) (r5.bottom - r13);
        r0.add(new RectF(r5));
        r4 = r4 + 1;
    L22:
        r5.left = (int) Math.max(r5.left, this.mTextLayout.getSecondaryHorizontal(r9));
        r5.right = (int) Math.min(r5.right, this.mTextLayout.getSecondaryHorizontal(r10));
        goto L23
    L9:
        return new ArrayList(getTextServiceSelectionBoxes(r9, r10));
    L24:
        return r0;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
        if (r3.getItemId() != ID_COPY) goto L6;
        performCopy();
    L8:
        invalidate();
        return true;
    L6:
        if (r3.getItemId() != ID_SELECT_ALL) goto L8;
        performSelectAll();
        goto L8
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r4, Menu r5) {
        r5.add(0, ID_COPY, 0, 2131896014);
        r5.add(0, ID_SELECT_ALL, 1, 2131913727);
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        this.mActionMode = r1;
        return false;
    }

    public void setBindSelectionChange(boolean r1, int r2) {
        this.mIsBindSelectionChange = r1;
        this.mSign = r2;
    }

    public static /* synthetic */ int access$000(AndroidText r0, float r1, float r2) {
        return r0.getOffsetForPosition(r1, r2);
    }

    private double distanceBetweenPoints(PointF r5, float r6, float r7) {
        return Math.sqrt(Math.pow(r5.x - r6, 2.0d) + Math.pow(r5.y - r7, 2.0d));
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (super.getRenderer() != null) goto L5;
        return;
    L5:
        if (super.getRenderer().h == null) goto L7;
        super.getRenderer().h.measure();
    L7:
        super.getRenderer().h();
    }

    private ArrayList<RectF> setTextServiceTextSelection(float r3, float r4, float r5, float r6, boolean r7, boolean r8) {
        invalidate();
        if (r3 >= 0.0f) goto L5;
    L28:
        clearSelection();
        return new ArrayList();
    L5:
        if (r4 < 0.0f) goto L28;
        if (r5 < 0.0f) goto L28;
        if (r6 < 0.0f) goto L28;
        int r9 = getOffsetForPosition(r3, r4);
        int r10 = getOffsetForPosition(r5, r6);
        if (r9 < 0) goto L26;
        if (r10 < 0) goto L26;
        if (r9 != r10) goto L20;
        r10 = r10 + 1;
        if (getTextBoundingBoxes(r9, r10).isEmpty() == false) goto L20;
        if (r9 <= 0) goto L20;
        r9 = r9 - 1;
        r10 = r10 - 1;
    L20:
        ArrayList<RectF> r11 = getTextBoundingBoxes(Math.min(r9, r10), Math.max(r9, r10));
        if (r11.isEmpty() == false) goto L24;
        clearSelection();
        return r11;
    L24:
        this.mIsShowStartHandle = r7;
        this.mIsShowEndHandle = r8;
        this.mIsInSelection = true;
        updateSelectionRange(r9, r10);
        updateSelectStartEnd();
        return r11;
    L26:
        clearSelection();
        return new ArrayList();
    }

    public ArrayList<RectF> setTextSelection(float r3, float r4, float r5, float r6, boolean r7, boolean r8) {
        if (this.mTextraPage != null) goto L5;
        invalidate();
        if (r3 >= 0.0f) goto L9;
    L32:
        clearSelection();
        return new ArrayList();
    L9:
        if (r4 < 0.0f) goto L32;
        if (r5 < 0.0f) goto L32;
        if (r6 < 0.0f) goto L32;
        int r9 = getOffsetForPosition(r3, r4);
        int r10 = getOffsetForPosition(r5, r6);
        if (r9 < 0) goto L30;
        if (r10 < 0) goto L30;
        if (r9 != r10) goto L28;
        PointF r11 = getCenterPositionForOffset(r9);
        if (r9 == this.mTextLayout.getText().length()) goto L27;
        if (r9 > 0) goto L24;
    L26:
        r10 = r10 + 1;
        goto L28
    L24:
        if (r3 >= r11.x) goto L26;
    L27:
        r9 = r9 - 1;
    L28:
        this.mIsShowStartHandle = r7;
        this.mIsShowEndHandle = r8;
        this.mIsInSelection = true;
        updateSelectionRange(r9, r10);
        updateSelectStartEnd();
        return getTextBoundingBoxes(this.mSelectStart, this.mSelectEnd);
    L30:
        clearSelection();
        return new ArrayList();
    L5:
        return setTextServiceTextSelection(r3, r4, r5, r6, r7, r8);
    }
}
