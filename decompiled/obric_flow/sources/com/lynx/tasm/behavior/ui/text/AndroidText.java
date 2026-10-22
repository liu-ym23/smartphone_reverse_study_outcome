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
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.j;
import com.obric.launcher.widget.R$drawable;
import com.obric.launcher.widget.R$string;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import ko.h;
import ko.r;
import zm.d0;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AndroidText extends com.lynx.tasm.behavior.ui.view.b implements ActionMode.Callback {
    private static final int DEFAULT_TEXT_HANDLE_COLOR = -16614661;
    private static final int DEFAULT_TEXT_HANDLE_SIZE = 15;
    private static final int DEFAULT_TEXT_SELECTION_COLOR = 1714664933;
    private static final int ID_COPY = 65534;
    private static final int ID_SELECT_ALL = 65533;
    private static final float RESPONSE_TOUCH_RADIUS = 50.0f;
    protected static final String SELECTION_CHANGE_EVENT = "selectionchange";
    private static WeakReference<AndroidText> sWeakSelectingAndroidText;
    private ActionMode mActionMode;
    private b mCheckForLongPress;
    private int mDefaultHandlePlatformLength;
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
    protected PointF mTextTranslateOffset;
    protected d0 mTextUpdateBundle;

    public AndroidText(Context r10) {
        super(r10);
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
        this.mOverflowPicture = new Picture();
        this.mOverflow = 0;
        this.mOverflowPictureDirty = true;
        setFocusable(true);
        setWillNotDraw(false);
        this.mTextSelectionColor = DEFAULT_TEXT_SELECTION_COLOR;
        this.mTextSelectionHandleColor = DEFAULT_TEXT_HANDLE_COLOR;
        int r11 = Math.round(((LynxContext) r10).f10152u.density * 15.0f);
        this.mDefaultHandlePlatformLength = r11;
        this.mHandleSize = r11;
    }

    public static /* synthetic */ boolean access$002(AndroidText r5, boolean r10) {
        r5.mIsInSelection = r10;
        return r10;
    }

    public static /* synthetic */ PointF access$100(AndroidText r5) {
        return r5.mSelectStartPos;
    }

    public static /* synthetic */ PointF access$200(AndroidText r5) {
        return r5.mSelectEndPos;
    }

    public static /* synthetic */ int access$302(AndroidText r5, int r10) {
        r5.mSelectEnd = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(AndroidText r5, int r10) {
        r5.mSelectStart = r10;
        return r10;
    }

    public static /* synthetic */ int access$500(AndroidText r5, float r10, float r11) {
        return r5.getOffsetForPosition(r10, r11);
    }

    public static /* synthetic */ boolean access$602(AndroidText r5, boolean r10) {
        r5.mIsAdjustEndPos = r10;
        return r10;
    }

    public static /* synthetic */ b access$702(AndroidText r5, b r10) {
        r5.mCheckForLongPress = r10;
        return r10;
    }

    private void adjustEndPosition(float r5, float r10) {
        this.mIsAdjustEndPos = true;
        int r11 = getOffsetForPosition(r5, r10);
        if (r11 == this.mSelectStart) goto L5;
    L12:
        updateSelectionRange(this.mSelectStart, r11);
        return;
    L5:
        if (r11 != this.mTextLayout.getText().length()) goto L7;
    L11:
        r11 = r11 - 1;
        goto L12
    L7:
        if (r5 >= this.mSelectStartPos.x) goto L10;
        if (r11 > 0) goto L11;
    L10:
        r11 = r11 + 1;
        goto L12
    }

    private void adjustStartPosition(float r5, float r10) {
        this.mIsAdjustStartPos = true;
        int r11 = getOffsetForPosition(r5, r10);
        if (this.mSelectEnd == r11) goto L5;
    L12:
        updateSelectionRange(r11, this.mSelectEnd);
        return;
    L5:
        if (r11 != this.mTextLayout.getText().length()) goto L7;
    L11:
        r11 = r11 - 1;
        goto L12
    L7:
        if (r5 >= this.mSelectEndPos.x) goto L10;
        if (r11 > 0) goto L11;
    L10:
        r11 = r11 + 1;
        goto L12
    }

    private void clearOtherSelection() {
        if (this.mEnableCustomTextSelection == false) goto L5;
        return;
    L5:
        WeakReference<AndroidText> r5 = sWeakSelectingAndroidText;
        if (r5 == null) goto L11;
        AndroidText r10 = r5.get();
        if (r10 == null) goto L11;
        if (r10 == this) goto L11;
        r10.clearSelection();
        r10.invalidate();
    L11:
        sWeakSelectingAndroidText = new WeakReference(this);
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
        if (this.mIsInSelection == false) goto L5;
        onSelectionChange();
    L5:
        this.mIsInSelection = false;
        updateSelectionRange(this.mSelectStart, this.mSelectEnd);
        hideToolbar();
        this.mShouldResponseMove = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        Path r5 = this.mHighlightPath;
        if (r5 == null) goto L9;
        r5.reset();
        return;
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r5 = (Spanned) getText();
        int r10 = 0;
        a[] r11 = (a[]) r5.getSpans(0, r5.length(), a.class);
        int r12 = r11.length;
    L7:
        if (r10 >= r12) goto L12;
        a r13 = r11[r10];
        r13.h();
        r13.c(null);
        r10 = r10 + 1;
        goto L7
    L12:
        return;
    }

    private double distanceBetweenPoints(PointF r5, float r10, float r11) {
        return Math.sqrt(Math.pow(r5.y - r11, 2.0d) + Math.pow(r5.x - r10, 2.0d));
    }

    private void drawHighlight(Canvas r5) {
        if (this.mIsInSelection == false) goto L13;
        Path r10 = this.mHighlightPath;
        if (r10 != null) goto L7;
        return;
    L7:
        if (this.mHighlightPaint == null) goto L16;
        r10.reset();
        int r11 = Math.min(this.mSelectStart, this.mSelectEnd);
        int r12 = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mTextLayout.getSelectionPath(r11, r12, this.mHighlightPath);
        if (this.mHighlightPath.isEmpty() == true) goto L15;
        r5.drawPath(this.mHighlightPath, this.mHighlightPaint);
        return;
    L15:
        return;
    L16:
        return;
    }

    private void drawOverflowPicture() {
        if (this.mOverflowPictureDirty == true) goto L5;
        return;
    L5:
        if (this.mTextLayout == null) goto L20;
        Picture r5 = this.mOverflowPicture;
        if (r5 != null) goto L10;
        this.mOverflowPicture = new Picture();
    L11:
        Canvas r10 = this.mOverflowPicture.beginRecording(this.mTextLayout.getWidth(), this.mTextLayout.getHeight());
        r10.save();
        if (getClipBounds() == null) goto L14;
        r10.clipRect(getClipBounds());
    L14:
        drawTextOnCanvas(r10);
        if (this.mNeedDrawStroke == false) goto L17;
        t.g(this.mTextLayout, r10);
    L17:
        r10.restore();
        this.mOverflowPicture.endRecording();
        this.mOverflowPictureDirty = false;
        return;
    L10:
        r5.endRecording();
        goto L11
    }

    private void drawSelectEndCursor(Canvas r5) {
        r5.save();
        r5.translate(this.mEndHandlerPos.x - (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mEndHandlerPos.y - (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        this.mSelectionRightCursor.draw(r5);
        r5.restore();
    }

    private void drawSelectHandle(Canvas r5) {
        if (this.mIsShowStartHandle == false) goto L6;
        drawSelectStartCursor(r5);
    L6:
        if (this.mIsShowEndHandle == false) goto L9;
        drawSelectEndCursor(r5);
        return;
    }

    private void drawSelectStartCursor(Canvas r5) {
        r5.save();
        r5.translate(this.mStartHandlerPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mStartHandlerPos.y - (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mSelectionLeftCursor.draw(r5);
        r5.restore();
    }

    private void drawText(Canvas r5) {
        drawHighlight(r5);
        drawTextOnCanvas(r5);
        if (this.mNeedDrawStroke == false) goto L5;
        t.g(this.mTextLayout, r5);
    L5:
        t.e(r5, this.mTextLayout);
    }

    private void drawTextOnCanvas(Canvas r5) {
        this.mTextLayout.draw(r5);
    }

    private PointF getBottomPositionForOffset(int r5, boolean r10) {
        float r11 = this.mTextLayout.getPrimaryHorizontal(r5);
        int r12 = this.mTextLayout.getLineForOffset(r5);
        float r13 = this.mTextLayout.getLineBottom(r12);
        if (r5 != this.mTextLayout.getLineStart(r12)) goto L8;
        if (r12 <= 0) goto L8;
        if (r10 == true) goto L8;
        r11 = this.mTextLayout.getWidth();
        r13 = this.mTextLayout.getLineBottom(r12 - 1);
    L8:
        return new PointF(r11, r13);
    }

    private PointF getCenterPositionForOffset(int r5) {
        if (r5 < 0) goto L9;
        if (r5 > this.mTextLayout.getText().length()) goto L9;
        int r10 = this.mTextLayout.getLineForOffset(r5);
        return new PointF(this.mTextLayout.getPrimaryHorizontal(r5), (this.mTextLayout.getLineBottom(r10) + this.mTextLayout.getLineTop(r10)) / 2.0f);
    L9:
        return new PointF(0.0f, 0.0f);
    }

    private int getLineAtCoordinate(float r5) {
        return this.mTextLayout.getLineForVertical((int) Math.min(getHeight() - 1, Math.max(0.0f, r5)));
    }

    private int getOffsetAtCoordinate(int r11, float r12) {
        int r5 = this.mTextLayout.getOffsetForHorizontal(r11, Math.min(getWidth() - 1, Math.max(0.0f, r12)));
        float r10 = this.mTextLayout.getSecondaryHorizontal(r5);
        if (r12 > ((((double) (this.mTextLayout.getLineRight(r11) - r10)) / 2.0d) + ((double) r10))) goto L5;
        return r5;
    L5:
        return this.mTextLayout.getLineEnd(r11);
    }

    private int getOffsetForPosition(float r5, float r10) {
        if (this.mTextLayout != null) goto L7;
        return -1;
    L7:
        return getOffsetAtCoordinate(getLineAtCoordinate(r10), r5);
    }

    private void hideToolbar() {
        if (this.mEnableCustomContextMenu == true) goto L9;
        ActionMode r5 = this.mActionMode;
        if (r5 == null) goto L10;
        r5.finish();
        this.mActionMode = null;
        return;
    L10:
        return;
    }

    private void initSelectionCursor(Context r5) {
        this.mSelectionLeftCursor = r5.getResources().getDrawable(R$drawable.lynx_text_select_handle_left_material);
        this.mSelectionRightCursor = r5.getResources().getDrawable(R$drawable.lynx_text_select_handle_right_material);
        Paint r10 = new Paint();
        this.mHighlightPaint = r10;
        r10.setStyle(Paint.Style.FILL);
        this.mHighlightPath = new Path();
    }

    private void onSelectionChange() {
        if (this.mIsBindSelectionChange == true) goto L5;
        return;
    L5:
        if ((getContext() instanceof LynxContext) == false) goto L13;
        i r5 = new i(this.mSign, SELECTION_CHANGE_EVENT);
        r5.a("start", Integer.valueOf(this.mSelectStart));
        r5.a("end", Integer.valueOf(this.mSelectEnd));
        if (this.mIsForward == false) goto L9;
        String r10 = "forward";
    L10:
        r5.a("direction", r10);
        ((LynxContext) getContext()).g.b(r5);
        return;
    L9:
        r10 = "backward";
        goto L10
    }

    private void performBeginSelection(float r10, float r11) {
        hideToolbar();
        if (this.mIsInSelection == false) goto L12;
        this.mShouldResponseMove = true;
        if (distanceBetweenPoints(this.mStartHandlerPos, r10, r11) >= 50.0d) goto L8;
        adjustStartPosition(r10, r11);
        requestDisallowInterceptTouchEvent(true);
        goto L12
    L8:
        if (distanceBetweenPoints(this.mEndHandlerPos, r10, r11) >= 50.0d) goto L10;
        adjustEndPosition(r10, r11);
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
        b r5 = new b(this, r10, r11);
        this.mCheckForLongPress = r5;
        postDelayed(r5, ViewConfiguration.getLongPressTimeout());
        return;
    }

    private void performCopy() {
        int r5 = this.mSelectStart;
        if (r5 < 0) goto L13;
        int r10 = this.mSelectEnd;
        if (r10 <= r5) goto L13;
        if (r10 > this.mTextLayout.getText().length()) goto L13;
        ClipData r11 = ClipData.newPlainText("Lynx-clipboard", this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd));
        if (r.g().e(h.class) != null) goto L12;
        ((ClipboardManager) getContext().getSystemService(ClipboardManager.class)).setPrimaryClip(r11);
        goto L13
    L12:
        throw new ClassCastException();
    L13:
        clearSelection();
    }

    private void performEndSelection(float r5, float r10) {
        requestDisallowInterceptTouchEvent(false);
        if (this.mIsInSelection == true) goto L6;
        removeCheckLongPressCallback();
        return;
    L6:
        boolean r11 = this.mIsAdjustEndPos;
        if (r11 == true) goto L13;
        if (this.mIsAdjustStartPos == true) goto L13;
        clearSelection();
        return;
    L13:
        if (this.mIsAdjustStartPos == false) goto L15;
        adjustStartPosition(r5, r10);
        updateSelectStartEnd();
    L17:
        showToolbar();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        return;
    L15:
        if (r11 == false) goto L17;
        adjustEndPosition(r5, r10);
        updateSelectStartEnd();
        goto L17
    }

    private void performMovingSelection(float r5, float r10) {
        b r11 = this.mCheckForLongPress;
        if (r11 == null) goto L10;
        if (Math.abs(r5 - r11.f10704a) <= 1.0f) goto L7;
    L8:
        removeCheckLongPressCallback();
        goto L10
    L7:
        if (Math.abs(r10 - this.mCheckForLongPress.f10705b) > 1.0f) goto L8;
    L10:
        if (this.mIsAdjustStartPos == false) goto L14;
        adjustStartPosition(r5, r10);
        return;
    L14:
        if (this.mIsAdjustEndPos == false) goto L17;
        adjustEndPosition(r5, r10);
        return;
    }

    private void performSelectAll() {
        updateSelectionRange(0, this.mTextLayout.getText().length());
        updateSelectStartEnd();
    }

    private void removeCheckLongPressCallback() {
        b r5 = this.mCheckForLongPress;
        if (r5 != null) goto L5;
        return;
    L5:
        removeCallbacks(r5);
        this.mCheckForLongPress = null;
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
    }

    private void showToolbar() {
        if (this.mEnableCustomContextMenu == false) goto L5;
        return;
    L5:
        startActionMode(this, 1);
    }

    private void updateSelectStartEnd() {
        int r5 = Math.min(this.mSelectStart, this.mSelectEnd);
        this.mSelectEnd = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mSelectStart = r5;
        onSelectionChange();
        this.mSelectStartPos.set(getBottomPositionForOffset(this.mSelectStart, true));
        this.mSelectEndPos.set(getBottomPositionForOffset(this.mSelectEnd, false));
    }

    private void updateSelectionRange(int r5, int r10) {
        if (this.mSelectionLeftCursor != null) goto L5;
        initSelectionCursor(getContext());
    L5:
        updateSelectionStyle();
        int r11 = this.mLastSelectStart;
        if (r11 != (-1)) goto L9;
        if (r10 > r5) goto L14;
    L13:
        boolean r12 = false;
    L15:
        this.mIsForward = r12;
        this.mLastSelectStart = this.mSelectStart;
        this.mLastSelectEnd = this.mSelectEnd;
        this.mSelectStart = r5;
        this.mSelectEnd = r10;
        if (r5 < 0) goto L29;
        if (r5 > this.mTextLayout.getText().length()) goto L29;
        int r13 = this.mSelectEnd;
        if (r13 < 0) goto L29;
        if (r13 > this.mTextLayout.getText().length()) goto L29;
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L26;
        Selection.setSelection((Spannable) this.mTextLayout.getText(), Math.min(this.mSelectStart, this.mSelectEnd), Math.max(this.mSelectStart, this.mSelectEnd));
    L26:
        this.mSelectStartPos.set(getBottomPositionForOffset(Math.min(this.mSelectStart, this.mSelectEnd), true));
        this.mSelectEndPos.set(getBottomPositionForOffset(Math.max(this.mSelectStart, this.mSelectEnd), false));
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), (this.mSelectionLeftCursor.getBounds().height() / 2.0f) + this.mSelectStartPos.y);
        this.mEndHandlerPos.set((this.mSelectionRightCursor.getBounds().width() / 2.0f) + this.mSelectEndPos.x, (this.mSelectionRightCursor.getBounds().height() / 2.0f) + this.mSelectEndPos.y);
        clearOtherSelection();
        return;
    L29:
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L32;
        Selection.removeSelection((Spannable) this.mTextLayout.getText());
        return;
    L32:
        return;
    L14:
        r12 = true;
        goto L15
    L9:
        if (r11 < r5) goto L14;
        if (this.mLastSelectEnd >= r10) goto L13;
        goto L13
    }

    private void updateSelectionStyle() {
        Drawable r5 = this.mSelectionLeftCursor;
        int r10 = this.mHandleSize;
        r5.setBounds(0, 0, r10, r10);
        Drawable r11 = this.mSelectionRightCursor;
        int r12 = this.mHandleSize;
        r11.setBounds(0, 0, r12, r12);
        this.mSelectionLeftCursor.setTint(this.mTextSelectionHandleColor);
        this.mSelectionRightCursor.setTint(this.mTextSelectionHandleColor);
        this.mHighlightPaint.setColor(this.mTextSelectionColor);
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        super.dispatchDraw(r5);
        if (this.mIsInSelection == false) goto L11;
        Path r10 = this.mHighlightPath;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == true) goto L13;
        r5.save();
        r5.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        drawSelectHandle(r5);
        r5.restore();
        return;
    L13:
        return;
    }

    public Layout generateTextLayout(d0 r5) {
        return r5.f23476c;
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (this.mIsInSelection == false) goto L5;
        ArrayList r5 = new ArrayList();
        r5.add(Float.valueOf(this.mStartHandlerPos.x));
        r5.add(Float.valueOf(this.mStartHandlerPos.y));
        r5.add(Float.valueOf(50.0f));
        ArrayList r10 = new ArrayList();
        r10.add(Float.valueOf(this.mEndHandlerPos.x));
        r10.add(Float.valueOf(this.mEndHandlerPos.y));
        r10.add(Float.valueOf(50.0f));
        return new ArrayList[]{r5, r10};
    L5:
        return new ArrayList[0];
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    public String getSelectedText() {
        int r5 = this.mSelectStart;
        if (r5 < 0) goto L11;
        int r10 = this.mSelectEnd;
        if (r10 <= 0) goto L13;
        if (r10 > r5) goto L8;
        return "";
    L8:
        if (r10 <= this.mTextLayout.getText().length()) goto L10;
        return "";
    L10:
        return this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd).toString();
    L13:
        return "";
    L11:
        return "";
    }

    public CharSequence getText() {
        Layout r5 = this.mTextLayout;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getText();
    }

    public ArrayList<RectF> getTextBoundingBoxes(int r10, int r11) {
        ArrayList<RectF> r5 = new ArrayList();
        Layout r12 = this.mTextLayout;
        if (r12 != null) goto L5;
    L19:
        return r5;
    L5:
        if (r12.getText().length() < r11) goto L19;
        if (r10 > r11) goto L19;
        if (r10 < 0) goto L19;
        if (r10 != r11) goto L12;
        int r13 = this.mTextLayout.getLineForOffset(r10);
        r5.add(new RectF(0.0f, 0.0f, 0.0f, this.mTextLayout.getLineBottom(r13) - this.mTextLayout.getLineTop(r13)));
        return r5;
    L12:
        int r14 = this.mTextLayout.getLineForOffset(r10);
        int r15 = this.mTextLayout.getLineForOffset(r11);
        int r16 = r14;
    L13:
        if (r16 > r15) goto L19;
        Rect r17 = new Rect();
        this.mTextLayout.getLineBounds(r16, r17);
        if (r16 == r14) goto L17;
        if (r16 == r15) goto L17;
    L18:
        float r18 = r17.left;
        PointF r19 = this.mTextTranslateOffset;
        float r20 = r19.x;
        r17.left = (int) (r18 - r20);
        r17.right = (int) (r17.right - r20);
        float r21 = r17.top;
        float r22 = r19.y;
        r17.top = (int) (r21 - r22);
        r17.bottom = (int) (r17.bottom - r22);
        r5.add(new RectF(r17));
        r16 = r16 + 1;
    L17:
        r17.left = (int) Math.max(r17.left, this.mTextLayout.getSecondaryHorizontal(r10));
        r17.right = (int) Math.min(r17.right, this.mTextLayout.getSecondaryHorizontal(r11));
        goto L18
    }

    @Nullable
    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    @Keep
    public void invalidateDrawable(Drawable r5) {
        if (j.j() == true) goto L6;
        return;
    L6:
        if (this.mHasImage == true) goto L8;
    L15:
        super.invalidateDrawable(r5);
        return;
    L8:
        if ((getText() instanceof Spanned) == false) goto L15;
        Spanned r10 = (Spanned) getText();
        int r11 = 0;
        a[] r12 = (a[]) r10.getSpans(0, r10.length(), a.class);
        int r13 = r12.length;
    L10:
        if (r11 >= r13) goto L15;
        if (r12[r11].e() != r5) goto L14;
        invalidate();
        this.mOverflowPictureDirty = true;
    L14:
        r11 = r11 + 1;
        goto L10
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r5, MenuItem r10) {
        if (r10.getItemId() != ID_COPY) goto L6;
        performCopy();
    L8:
        invalidate();
        return true;
    L6:
        if (r10.getItemId() != ID_SELECT_ALL) goto L8;
        performSelectAll();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    @Keep
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        a.d((Spanned) getText(), this);
        return;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r5, Menu r10) {
        r10.add(0, ID_COPY, 0, R$string.copy);
        r10.add(0, ID_SELECT_ALL, 1, R$string.selectAll);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    @Keep
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispatchDetachImageSpan();
    }

    @Override // android.view.View
    @Keep
    public void onDraw(Canvas r5) {
        if (this.mTextLayout == null) goto L10;
        r5.save();
        r5.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        if (this.mOverflow == 0) goto L7;
        drawHighlight(r5);
        drawOverflowPicture();
        r5.drawPicture(this.mOverflowPicture);
    L8:
        r5.restore();
        return;
    L7:
        drawText(r5);
        goto L8
    }

    @Override // android.view.View
    @Keep
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r5 = (Spanned) getText();
        int r10 = 0;
        a[] r11 = (a[]) r5.getSpans(0, r5.length(), a.class);
        int r12 = r11.length;
    L7:
        if (r10 >= r12) goto L12;
        r11[r10].i();
        r10 = r10 + 1;
        goto L7
    L12:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    @Keep
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.View
    @Keep
    public void onMeasure(int r5, int r10) {
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.MeasureSpec.getSize(r10));
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r5, Menu r10) {
        this.mActionMode = r5;
        return false;
    }

    @Override // android.view.View
    @Keep
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r5 = (Spanned) getText();
        int r10 = 0;
        a[] r11 = (a[]) r5.getSpans(0, r5.length(), a.class);
        int r12 = r11.length;
    L7:
        if (r10 >= r12) goto L12;
        r11[r10].j();
        r10 = r10 + 1;
        goto L7
    L12:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mTextLayout == null) goto L25;
        if (this.mEnableTextSelection == false) goto L25;
        if (this.mEnableCustomTextSelection == true) goto L25;
        float r5 = r10.getX() - getPaddingLeft();
        float r11 = r10.getY() - getPaddingTop();
        if (r10.getAction() != 0) goto L13;
        performBeginSelection(r5, r11);
    L22:
        invalidate();
        return true;
    L13:
        if (r10.getAction() != 2) goto L16;
        performMovingSelection(r5, r11);
        goto L22
    L16:
        if (r10.getAction() != 1) goto L19;
        performEndSelection(r5, r11);
        goto L22
    L19:
        if (this.mShouldResponseMove == false) goto L21;
        performEndSelection(r5, r11);
        goto L22
    L21:
        removeCheckLongPressCallback();
    L25:
        return super.onTouchEvent(r10);
    }

    public void release() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        a.d((Spanned) getText(), null);
        return;
    }

    public void setBindSelectionChange(boolean r5, int r10) {
        this.mIsBindSelectionChange = r5;
        this.mSign = r10;
    }

    public void setCustomContextMenu(boolean r5) {
        this.mEnableCustomContextMenu = r5;
    }

    public void setCustomTextSelection(boolean r5) {
        this.mEnableCustomTextSelection = r5;
    }

    public void setEnableTextSelection(boolean r5) {
        this.mEnableTextSelection = r5;
    }

    public void setOverflow(int r5) {
        this.mOverflow = r5;
    }

    public void setTextBundle(d0 r5) {
        dispatchDetachImageSpan();
        this.mTextUpdateBundle = r5;
        this.mTextLayout = generateTextLayout(r5);
        this.mTextTranslateOffset = r5.e;
        boolean r10 = r5.f23474a;
        this.mHasImage = r10;
        this.mNeedDrawStroke = r5.f;
        this.mIsJustify = r5.f23475b;
        this.mOriginText = r5.g;
        if (r10 == false) goto L8;
        if ((getText() instanceof Spanned) == false) goto L8;
        a.d((Spanned) getText(), this);
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

    public void setTextGradient(ReadableArray r5) {
    }

    public ArrayList<RectF> setTextSelection(float r5, float r10, float r11, float r12, boolean r13, boolean r14) {
        invalidate();
        if (r5 >= 0.0f) goto L5;
    L28:
        clearSelection();
        return new ArrayList();
    L5:
        if (r10 < 0.0f) goto L28;
        if (r11 < 0.0f) goto L28;
        if (r12 < 0.0f) goto L28;
        int r15 = getOffsetForPosition(r5, r10);
        int r16 = getOffsetForPosition(r11, r12);
        if (r15 < 0) goto L26;
        if (r16 < 0) goto L26;
        if (r15 != r16) goto L24;
        PointF r17 = getCenterPositionForOffset(r15);
        if (r15 == this.mTextLayout.getText().length()) goto L23;
        if (r15 > 0) goto L20;
    L22:
        r16 = r16 + 1;
        goto L24
    L20:
        if (r5 >= r17.x) goto L22;
    L23:
        r15 = r15 - 1;
    L24:
        this.mIsShowStartHandle = r13;
        this.mIsShowEndHandle = r14;
        this.mIsInSelection = true;
        updateSelectionRange(r15, r16);
        updateSelectStartEnd();
        return getTextBoundingBoxes(this.mSelectStart, this.mSelectEnd);
    L26:
        clearSelection();
        return new ArrayList();
    }

    public void updateSelectionBackgroundColor(int r5) {
        if (r5 != 0) goto L4;
        r5 = DEFAULT_TEXT_SELECTION_COLOR;
    L4:
        this.mTextSelectionColor = r5;
    }

    public void updateSelectionHandleColor(int r5) {
        if (r5 != 0) goto L4;
        r5 = DEFAULT_TEXT_HANDLE_COLOR;
    L4:
        this.mTextSelectionHandleColor = r5;
    }

    public void updateSelectionHandleSize(int r5) {
        if (r5 > 0) goto L4;
        r5 = this.mDefaultHandlePlatformLength;
    L4:
        this.mHandleSize = r5;
    }

    @Override // android.view.View
    @Keep
    public boolean verifyDrawable(Drawable r5) {
        if (this.mHasImage == false) goto L14;
        if ((getText() instanceof Spanned) == false) goto L14;
        Spanned r10 = (Spanned) getText();
        int r11 = 0;
        a[] r12 = (a[]) r10.getSpans(0, r10.length(), a.class);
        int r13 = r12.length;
    L7:
        if (r11 >= r13) goto L14;
        if (r12[r11].e() == r5) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return true;
    L14:
        return super.verifyDrawable(r5);
    }

    @Deprecated
    public void setTextGradient(String r5) {
        LynxLog.b(4, "text-gradient", "setTextGradient(String) is deprecated, call this function has no effect");
    }
}
