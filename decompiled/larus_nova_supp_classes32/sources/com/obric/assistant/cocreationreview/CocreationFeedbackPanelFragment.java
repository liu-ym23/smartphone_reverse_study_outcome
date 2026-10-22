package com.obric.assistant.cocreationreview;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0000\u0018\u0000 p2\u00020\u0001:\u0003nopB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020(H\u0016J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u00108\u001a\u000209H\u0016J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\fJ\u0014\u0010=\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010?\u001a\u00020(J\u0010\u0010@\u001a\u0002022\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u00020(H\u0002J\u0018\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\fH\u0002J\b\u0010H\u001a\u000202H\u0002J\b\u0010I\u001a\u00020(H\u0002J\u0010\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u000fH\u0002J\u0010\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020\nH\u0002J\b\u0010N\u001a\u00020(H\u0002J\u0016\u0010O\u001a\u00020(2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\tH\u0002J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u000fH\u0002J\u0016\u0010T\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020(H\u0002J\u0010\u0010X\u001a\u00020(2\u0006\u0010M\u001a\u00020\nH\u0002J\u001a\u0010Y\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010M\u001a\u00020\nH\u0002J\u001e\u0010Z\u001a\u00020\n*\u00020[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\u000f2\u0006\u0010`\u001a\u00020[H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010a\u001a\u00020(H\u0002J\b\u0010b\u001a\u00020(H\u0002J\b\u0010c\u001a\u00020(H\u0002J\b\u0010d\u001a\u000202H\u0002J\f\u0010e\u001a\u00020f*\u00020*H\u0002J\f\u0010g\u001a\u00020\u0005*\u00020-H\u0002J2\u0010h\u001a\u0002Hi\"\u0010\b\u0000\u0010i\u0018\u0001*\b\u0012\u0004\u0012\u0002Hi0j2\b\u0010k\u001a\u0004\u0018\u00010\u000f2\u0006\u0010l\u001a\u0002HiH\u0082\b¢\u0006\u0002\u0010mJ\f\u0010Z\u001a\u00020\n*\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006q"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationFeedbackPanelFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "template", "Lcom/obric/assistant/cocreationreview/FeedbackPanelTemplate;", "feedback", "Lcom/obric/assistant/cocreationreview/Feedback;", "media", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/FeedbackMediaDraft;", "submitting", NameKeys.UnloadStrategy_No_Strategy, "submitted", "dismissSource", NameKeys.UnloadStrategy_No_Strategy, "dismissCallbackSent", "reasonContainer", "Landroid/widget/LinearLayout;", "submitButton", "Landroid/widget/TextView;", "stateText", "countText", "commentEditText", "Landroid/widget/EditText;", "mediaContainer", "bottomActionContainer", "editingMediaId", "photoEditResultRegistered", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "mediaPickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "callback", "Lcom/obric/assistant/cocreationreview/CocreationFeedbackPanelFragment$Callback;", "getCallback", "()Lcom/obric/assistant/cocreationreview/CocreationFeedbackPanelFragment$Callback;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setSubmitting", "isSubmitting", "updateMedia", "next", "dismissAfterSubmit", "renderPanel", "applyImeInsetsToPanel", "panel", "panelHeader", "renderReasons", "reasonChip", "reason", "selected", "commentInput", "renderMedia", "mediaPickerButton", "text", "mediaTile", "current", "openMediaPicker", "handleSelectedAlbumItems", "items", "Lcom/larus/platform/model/album/AlbumSelectItem;", "removeMedia", "mediaId", "updateMediaDrafts", "maxMediaCount", NameKeys.UnloadStrategy_No_Strategy, "registerPhotoEditResult", "openImageEditor", "prepareImageForEdit", "toFeedbackMediaDraft", "Landroid/net/Uri;", "durationMillis", NameKeys.UnloadStrategy_No_Strategy, "format", "queryDisplayName", LynxResourceModule.URI_KEY, "renderBottomActions", "updateSubmitState", "notifyDismissIfNeeded", "panelHandle", "panelBackground", "Landroid/graphics/drawable/GradientDrawable;", "toTemplate", "enumValueOrDefault", "T", NameKeys.UnloadStrategy_No_Strategy, "raw", LynxUIWebView.DEFAULT, "(Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "Callback", "CenteredCloseButton", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationFeedbackPanelFragment extends DialogFragment {
    public static final Set<String> v = null;
    public d5 d;
    public a5 e;
    public List<b5> f;
    public boolean g;
    public boolean h;
    public String i;
    public boolean j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public EditText o;
    public LinearLayout p;
    public LinearLayout q;
    public String r;
    public boolean s;
    public final LocalTakePictureImpl t;
    public final ActivityResultLauncher<Intent> u;

    public interface a {
        void Q(String r1, String r2);

        void R0(String r1, String r2);

        void S0(String r1);

        void h1(String r1, List<b5> r2);

        void o(String r1, String r2);
    }

    public static final class b extends View {
        public final Paint a;
        public final Paint b;
        public final float c;

        public b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
            Paint r0 = new Paint(1);
            r0.setColor(-658192);
            r0.setStyle(Paint.Style.FILL);
            this.a = r0;
            Paint r1 = new Paint(1);
            r1.setColor(-15656921);
            r1.setStrokeWidth(c4.c(r4, 2));
            r1.setStrokeCap(Paint.Cap.ROUND);
            this.b = r1;
            this.c = c4.c(r4, 7);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r10) {
            Intrinsics.checkNotNullParameter(r10, "canvas");
            super.onDraw(r10);
            float r0 = getWidth() / 2.0f;
            float r2 = getHeight() / 2.0f;
            r10.drawCircle(r0, r2, Math.min(getWidth(), getHeight()) / 2.0f, this.a);
            float r1 = this.c;
            r10.drawLine(r0 - r1, r2 - r1, r0 + r1, r2 + r1, this.b);
            float r3 = this.c;
            r10.drawLine(r0 + r3, r2 - r3, r0 - r3, r2 + r3, this.b);
        }
    }

    public static final class c {
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedbackMediaUploadState.values().length];
            r0[FeedbackMediaUploadState.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FeedbackMediaUploadState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FeedbackMediaUploadState.READY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FeedbackMediaUploadState.UPLOADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        v = SetsKt.setOf(new String[]{"mp4", "mov", "m4v", "avi", "mkv", "webm"});
    }

    public final void aa0() {
        Context r1 = requireContext();
        LinearLayout r8 = this.p;
        if (r8 == null) goto L51;
        r8.removeAllViews();
        if (this.f.isEmpty() == true) goto L52;
        Intrinsics.checkNotNull(r1);
        int r4 = 0;
        c4.b(r8, c4.f(r1, "上传内容 · " + this.f.size(), 12.0f, -9735552, 1), 0, 0, c4.c(r1, 6), 6);
        LinearLayout r2 = c4.e(r1);
        r2.setGravity(48);
        Iterator r3 = this.f.iterator();
        int r5 = 0;
    L10:
        if (r3.hasNext() == false) goto L45;
        Object r6 = r3.next();
        int r11 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final b5 r7 = (b5) r6;
        Context r12 = requireContext();
        FrameLayout r13 = new FrameLayout(r12);
        Intrinsics.checkNotNull(r12);
        if (r7.h != FeedbackMediaUploadState.FAILED) goto L17;
        int r14 = -10193781;
    L18:
        r13.setBackground(c4.h(r12, -1, 10, r14, 1));
        ImageView r15 = new ImageView(r12);
        r15.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r15.setBackgroundColor(-1512205);
        r15.setContentDescription(r7.d);
        r15.setBackground(c4.h(r12, -1512205, 10, r4, r4));
        r15.setClipToOutline(true);
        r15.setEnabled(!this.g);
        if (r7.getType() != FeedbackMediaType.IMAGE) goto L21;
        r15.setOnClickListener(new c0(this, r7));
    L21:
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        Iterator r16 = r3;
        r9.setMargins(c4.c(r12, 1), c4.c(r12, 1), c4.c(r12, 1), c4.c(r12, 1));
        Unit r10 = Unit.INSTANCE;
        r13.addView(r15, r9);
        ExecutorService r17 = p.a;
        p.c(r15, r7, c4.c(r12, 64));
        if (r7.getType() != FeedbackMediaType.VIDEO) goto L24;
        TextView r18 = c4.f(r12, "视频", 10.0f, -1, 1);
        r18.setGravity(17);
        r18.setBackground(c4.h(r12, -1728053248, 4, 0, 0));
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(c4.c(r12, 32), c4.c(r12, 20), 8388691);
        r19.setMargins(c4.c(r12, 5), 0, 0, c4.c(r12, 5));
        r13.addView(r18, r19);
    L24:
        int r20 = d.a[r7.h.ordinal()];
        if (r20 != 1) goto L27;
        int r110 = -1;
        StringBuilder r21 = new StringBuilder();
        r21.append(r7.i);
        r21.append('%');
        TextView r22 = c4.f(r12, r21.toString(), 12.0f, -1, 1);
        r22.setGravity(17);
        r22.setBackground(c4.h(r12, -1728053248, 10, 0, 0));
        r13.addView(r22, new FrameLayout.LayoutParams(-1, -1));
    L38:
        if (this.g == true) goto L40;
        TextView r23 = c4.f(r12, "×", 20.0f, r110, 0);
        r23.setGravity(17);
        GradientDrawable r24 = new GradientDrawable();
        r24.setShape(1);
        r24.setColor(-869057976);
        r23.setBackground(r24);
        r23.setContentDescription("删除" + r7.d);
        r23.setOnClickListener(new d0(this, r7));
        FrameLayout.LayoutParams r25 = new FrameLayout.LayoutParams(c4.c(r12, 26), c4.c(r12, 26), 8388661);
        r25.setMargins(0, c4.c(r12, 4), c4.c(r12, 4), 0);
        r13.addView(r23, r25);
    L40:
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(c4.c(r1, 64), c4.c(r1, 64));
        if (r5 >= CollectionsKt.getLastIndex(this.f)) goto L44;
        r26.setMargins(0, 0, c4.c(r1, 8), 0);
    L44:
        r2.addView(r13, r26);
        r5 = r11;
        r3 = r16;
        r4 = 0;
        goto L10
    L27:
        if (r20 != 2) goto L29;
        TextView r27 = c4.f(r12, "上传失败", 10.0f, -1, 1);
        r27.setGravity(17);
        r27.setBackground(c4.h(r12, -857981390, 4, 0, 0));
        r110 = -1;
        r13.addView(r27, new FrameLayout.LayoutParams(-1, c4.c(r12, 22), 80));
        goto L38
    L29:
        if (r20 == 3) goto L34;
        if (r20 == 4) goto L34;
        throw new NoWhenBranchMatchedException();
    L34:
        r110 = -1;
        goto L38
    L17:
        r14 = -1512723;
        goto L18
    L45:
        HorizontalScrollView r28 = new HorizontalScrollView(r1);
        r28.setHorizontalScrollBarEnabled(false);
        r28.setOverScrollMode(2);
        r28.addView(r2, new ViewGroup.LayoutParams(-2, -2));
        c4.b(r8, r28, 0, 0, 0, 14);
        return;
    L52:
        return;
    }

    public final void ba0() {
        Context r1 = requireContext();
        LinearLayout r8 = this.k;
        if (r8 == null) goto L51;
        r8.removeAllViews();
        d5 r2 = this.d;
        d5 r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r2 = null;
    L8:
        float r9 = 13.0f;
        if (r2.d.isEmpty() == false) goto L15;
        Intrinsics.checkNotNull(r1);
        d5 r4 = this.d;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L14:
        c4.b(r8, c4.f(r1, r3.g, 13.0f, -9735552, 0), 0, 0, 0, 14);
        return;
    L13:
        r3 = r4;
        goto L14
    L15:
        Intrinsics.checkNotNull(r1);
        LinearLayout r5 = c4.e(r1);
        d5 r6 = this.d;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L19:
        Iterator<T> r11 = r3.d.iterator();
        LinearLayout r7 = r5;
        int r10 = 0;
        int r12 = 0;
    L21:
        if (r11.hasNext() == false) goto L43;
        Object r13 = r11.next();
        int r14 = r10 + 1;
        if (r10 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        final String r15 = (String) r13;
        int r16 = r15.length() + 4;
        if (r10 > 0) goto L28;
    L30:
        boolean r17 = this.e.c.contains(r15);
        Context r18 = requireContext();
        Intrinsics.checkNotNull(r18);
        if (r17 == false) goto L33;
        int r19 = -1;
    L34:
        TextView r20 = c4.f(r18, r15, r9, r19, 1);
        r20.setGravity(17);
        r20.setPadding(c4.c(r18, 12), 0, c4.c(r18, 12), 0);
        int r21 = -14979842;
        if (r17 == false) goto L37;
        int r110 = -14979842;
    L38:
        if (r17 == true) goto L41;
        r21 = 0;
    L41:
        r20.setBackground(c4.h(r18, r110, 17, r21, r17 ? 1 : 0));
        r20.setClickable(!this.g);
        r20.setFocusable(!this.g);
        r20.setOnClickListener(new t(this, r15));
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(-2, c4.c(r1, 34));
        r22.setMargins(0, 0, c4.c(r1, 8), 0);
        Unit r23 = Unit.INSTANCE;
        r7.addView(r20, r22);
        r12 = r12 + r16;
        r10 = r14;
        r9 = 13.0f;
        goto L21
    L37:
        r110 = -658192;
        goto L38
    L33:
        r19 = -15656921;
        goto L34
    L28:
        if ((r12 + r16) <= 26) goto L30;
        c4.b(r8, r7, 0, 0, c4.c(r1, 8), 6);
        r7 = c4.e(r1);
        r12 = 0;
        goto L30
    L43:
        if (r7.getChildCount() <= 0) goto L50;
        c4.b(r8, r7, 0, 0, 0, 14);
        return;
    L50:
        return;
    L18:
        r3 = r6;
        goto L19
    }

    public final void ea0() {
        if (this.e.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        TextView r2 = this.m;
        d5 r3 = null;
        if (r2 != null) goto L11;
    L18:
        TextView r4 = this.l;
        if (r4 != null) goto L21;
        return;
    L21:
        if (this.g == false) goto L27;
        d5 r5 = this.d;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L26:
        String r6 = r3.i;
    L32:
        r4.setText(r6);
        if (r0 == false) goto L35;
        int r7 = -1;
    L36:
        r4.setTextColor(r7);
        Context r8 = requireContext();
        int r9 = -14979842;
        if (r0 == false) goto L39;
        int r10 = -14979842;
    L40:
        if (r0 == true) goto L43;
        r9 = -1512723;
    L43:
        r4.setBackground(c4.h(r8, r10, 23, r9, 1));
        r4.setEnabled(r0);
        return;
    L39:
        r10 = -394242;
        goto L40
    L35:
        r7 = -3616547;
        goto L36
    L25:
        r3 = r5;
        goto L26
    L27:
        d5 r11 = this.d;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L31:
        r6 = r3.h;
        goto L32
    L30:
        r3 = r11;
        goto L31
    L11:
        if (this.e.b() == false) goto L13;
        String r12 = "完成后将移入已反馈历史";
    L17:
        r2.setText(r12);
        goto L18
    L13:
        d5 r13 = this.d;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r13 = null;
    L16:
        r12 = r13.j;
        goto L17
    L5:
        if (this.g == true) goto L7;
        r0 = true;
        goto L8
    }

    public CocreationFeedbackPanelFragment() {
        this.e = new a5(NameKeys.UnloadStrategy_No_Strategy, null, null, null, false, 0, null, 254);
        this.f = CollectionsKt.emptyList();
        this.i = "system";
        this.t = new LocalTakePictureImpl();
        this.u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e0(this));
    }

    public final a X90() {
        a r0 = getActivity();
        if ((r0 instanceof a) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void Z90() {
        Context r0 = requireContext();
        LinearLayout r1 = this.q;
        if (r1 == null) goto L29;
        TextView r2 = this.l;
        if (r2 == null) goto L30;
        r1.removeAllViews();
        d5 r3 = this.d;
        String r4 = null;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r3 = null;
    L11:
        boolean r5 = r3.m;
        int r6 = this.f.size();
        ImFileUtil.a.getClass();
        int r7 = RangesKt.coerceAtLeast(ImFileUtil.m(), 1);
        if (r5 == false) goto L20;
        if (r6 >= r7) goto L20;
        if (r6 != 0) goto L17;
        String r8 = "+ 添加图片/视频";
    L18:
        r4 = r8;
        goto L20
    L17:
        r8 = "+ 继续上传";
    L20:
        if (r4 != null) goto L22;
        Intrinsics.checkNotNull(r0);
        r1.addView(r2, new LinearLayout.LayoutParams(0, c4.c(r0, 46), 1.0f));
        return;
    L22:
        Context r9 = requireContext();
        Intrinsics.checkNotNull(r9);
        if (this.g == false) goto L25;
        int r10 = -5721662;
    L26:
        TextView r11 = c4.f(r9, r4, 13.0f, r10, 1);
        r11.setGravity(17);
        r11.setPadding(c4.c(r9, 14), 0, c4.c(r9, 14), 0);
        r11.setBackground(c4.h(r9, -394242, 23, -1512723, 1));
        r11.setEnabled(true ^ this.g);
        r11.setOnClickListener(new y(this));
        Intrinsics.checkNotNull(r0);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(0, c4.c(r0, 46), 1.0f);
        r12.setMarginEnd(c4.c(r0, 10));
        Unit r13 = Unit.INSTANCE;
        r1.addView(r11, r12);
        r1.addView(r2, new LinearLayout.LayoutParams(0, c4.c(r0, 46), 1.2f));
        return;
    L25:
        r10 = -14979842;
        goto L26
    L30:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setDimAmount(0.45f);
        r1.clearFlags(134217728);
        r1.addFlags(2);
        r1.addFlags(Integer.MIN_VALUE);
        r1.setNavigationBarColor(-1);
        S90(r1).setSystemUiVisibility(((S90(r1).getSystemUiVisibility() | 256) | 512) | 16);
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        r1.setGravity(80);
        r1.setSoftInputMode(48);
        r1.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void T90(CocreationFeedbackPanelFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void Y90(String r5) {
        List<b5> r0 = this.f;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((b5) r3).a, r5) == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        da0(r1);
    }

    public final void ca0(boolean r5) {
        this.g = r5;
        setCancelable(!r5);
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.setCancelable(!r5);
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        r1.setCanceledOnTouchOutside(!r5);
    L8:
        TextView r2 = this.l;
        if (r2 == null) goto L21;
        d5 r3 = null;
        d5 r4 = this.d;
        if (r5 == false) goto L16;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L15:
        String r6 = r3.i;
    L20:
        r2.setText(r6);
        goto L21
    L14:
        r3 = r4;
        goto L15
    L16:
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L19:
        r6 = r3.h;
        goto L20
    L18:
        r3 = r4;
    L21:
        EditText r7 = this.o;
        if (r7 == null) goto L24;
        r7.setEnabled(!r5);
    L24:
        ba0();
        aa0();
        ea0();
        Z90();
    }

    public final void da0(List<b5> r3) {
        this.f = CollectionsKt.toList(r3);
        a r4 = X90();
        if (r4 == null) goto L8;
        d5 r0 = this.d;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r0 = null;
    L7:
        r4.h1(r0.a, this.f);
    L8:
        aa0();
        Z90();
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        if (this.s == true) goto L6;
        this.s = true;
        this.t.d(this, new z(this), new a0(this));
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.i = "cancel";
        super.onCancel(r2);
    }

    public final void onCreate(Bundle r35) {
        super.onCreate(r35);
        setStyle(1, 0);
        Bundle r3 = requireArguments();
        Iterable r0 = r3.getParcelableArrayList("media_items");
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterable r1 = r0;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L6:
        Object r19 = null;
        if (r4.hasNext() == false) goto L50;
        Bundle r6 = (Bundle) r4.next();
        Intrinsics.checkNotNull(r6);
        String r2 = r6.getString("media_id");
        if (r2 != null) goto L12;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        if (StringsKt.isBlank(r2) == false) goto L14;
        r2 = UUID.randomUUID().toString();
    L14:
        String r21 = r2;
        String r5 = r6.getString("media_uri");
        if (r5 != null) goto L17;
        String r22 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        String r7 = r6.getString("media_type");
        Enum r8 = FeedbackMediaType.IMAGE;
        if (r7 != null) goto L98;
    L31:
        FeedbackMediaType r23 = (FeedbackMediaType) r8;
        String r9 = r6.getString("media_display_name");
        if (r9 != null) goto L34;
        String r24 = NameKeys.UnloadStrategy_No_Strategy;
    L35:
        long r25 = r6.getLong("media_duration");
        boolean r27 = r6.getBoolean("media_is_marked");
        boolean r28 = r6.getBoolean("media_is_cropped");
        String r10 = r6.getString("media_upload_state");
        Enum r11 = FeedbackMediaUploadState.READY;
        if (r10 == null) goto L49;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L39
        Object r13 = Result.constructor-impl(FeedbackMediaUploadState.valueOf(r10));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r13) == true) goto L45;
        r19 = r13;
    L45:
        Enum r110 = (Enum) r19;
        if (r110 == null) goto L49;
        r11 = r110;
    L39:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        r15.add(new b5(r21, r22, r23, r24, r25, r27, r28, (FeedbackMediaUploadState) r11, r6.getInt("media_upload_progress"), r6.getString("media_upload_identifier"), r6.getString("media_remote_uri"), r6.getString("media_upload_error")));
        goto L6
    L34:
        r24 = r9;
        goto L35
    L98:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L22
        Object r17 = Result.constructor-impl(FeedbackMediaType.valueOf(r7));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r17) == false) goto L27;
        r17 = null;
    L27:
        Enum r18 = (Enum) r17;
        if (r18 == null) goto L31;
        r8 = r18;
    L22:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L17:
        r22 = r5;
        goto L18
    L50:
        String r26 = r3.getString("record_id");
        if (r26 != null) goto L53;
        r26 = NameKeys.UnloadStrategy_No_Strategy;
    L53:
        String r29 = r3.getString("title");
        if (r29 != null) goto L56;
        r29 = NameKeys.UnloadStrategy_No_Strategy;
    L56:
        String r30 = r3.getString("reasons_title");
        if (r30 != null) goto L59;
        r30 = NameKeys.UnloadStrategy_No_Strategy;
    L59:
        List r31 = r3.getStringArrayList("reasons");
        if (r31 != null) goto L62;
        r31 = CollectionsKt.emptyList();
    L62:
        String r32 = r3.getString("record_id");
        if (r32 != null) goto L65;
        String r210 = NameKeys.UnloadStrategy_No_Strategy;
    L66:
        Vote.a r33 = Vote.Companion;
        String r111 = r3.getString("feedback_vote");
        r33.getClass();
        Vote r211 = Vote.a.a(r111);
        Iterable r34 = r3.getStringArrayList("feedback_reasons");
        if (r34 != null) goto L69;
        r34 = CollectionsKt.emptyList();
    L69:
        Set r212 = (Set) CollectionsKt.toCollection(r34, new LinkedHashSet());
        String r36 = r3.getString("feedback_comment");
        if (r36 != null) goto L72;
        String r213 = NameKeys.UnloadStrategy_No_Strategy;
    L73:
        a5 r112 = new a5(r210, r211, r212, r213, r3.getBoolean("feedback_completed"), r3.getLong("feedback_created_at"), null, 192);
        String r37 = r3.getString("placeholder");
        if (r37 != null) goto L76;
        String r113 = NameKeys.UnloadStrategy_No_Strategy;
    L77:
        String r38 = r3.getString("empty_reasons_text");
        if (r38 != null) goto L80;
        String r114 = NameKeys.UnloadStrategy_No_Strategy;
    L81:
        String r39 = r3.getString("submit_text");
        if (r39 != null) goto L84;
        String r115 = NameKeys.UnloadStrategy_No_Strategy;
    L85:
        String r40 = r3.getString("submitting_text");
        if (r40 != null) goto L88;
        String r116 = NameKeys.UnloadStrategy_No_Strategy;
    L89:
        String r41 = r3.getString("incomplete_text");
        if (r41 != null) goto L92;
        String r117 = NameKeys.UnloadStrategy_No_Strategy;
    L93:
        d5 r42 = new d5(r26, r29, r30, r31, r112, r113, r114, r115, r116, r117, r3.getInt("max_comment_length"), r3.getBoolean("submitting"), r3.getBoolean("media_enabled"), r15);
        this.d = r42;
        this.e = r42.e;
        this.f = r42.n;
        d5 r43 = this.d;
        if (r43 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r43 = null;
    L96:
        boolean r44 = r43.l;
        this.g = r44;
        setCancelable(!r44);
        return;
    L92:
        r117 = r41;
        goto L93
    L88:
        r116 = r40;
        goto L89
    L84:
        r115 = r39;
        goto L85
    L80:
        r114 = r38;
        goto L81
    L76:
        r113 = r37;
        goto L77
    L72:
        r213 = r36;
        goto L73
    L65:
        r210 = r32;
        goto L66
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = new Dialog(requireContext());
        r4.requestWindowFeature(1);
        r4.setCancelable(!this.g);
        r4.setCanceledOnTouchOutside(true ^ this.g);
        return r4;
    }

    public final void onDismiss(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");     // Catch: Throwable -> L16
        if (this.h == false) goto L5;
    L13:
        super.onDismiss(r4);     // Catch: Throwable -> L16
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        if (this.j == true) goto L13;
        this.j = true;     // Catch: Throwable -> L16
        a r0 = X90();     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        d5 r1 = this.d;     // Catch: Throwable -> L16
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("template");     // Catch: Throwable -> L16
        r1 = null;
    L12:
        r0.Q(r1.a, this.i);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final String U90(CocreationFeedbackPanelFragment r7, Context r8, b5 r9) {
        r7.getClass();
        Uri r10 = UriProtector.parse(r9.b);
        if (Intrinsics.areEqual(r10.getScheme(), "file") == true) goto L51;
        String r0 = r10.getScheme();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
    L16:
        String r2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r8.getContentResolver().getType(r10));
        if (r2 != null) goto L19;
    L24:
        r2 = StringsKt.substringAfterLast(r9.d, '.', "jpg");
    L25:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r8.getCacheDir(), "cocreation_feedback_edit");
        r3.mkdirs();
        PolarisFileWrapper r5 = new PolarisFileWrapper(r3, r9.a + '.' + r2);
        InputStream r11 = ContentResolverWrapper.openInputStream(r8.getContentResolver(), r10);
        if (r11 == null) goto L53;
        PolarisFileOutputStreamWrapper r12 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L39
        ByteStreamsKt.copyTo$default(r11, r12, 0, 2, null);     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r11, null);
        return r5.getAbsolutePath();
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L53:
        return null;
    L19:
        if ((true ^ StringsKt.isBlank(r2)) == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L24;
    L14:
        if (new PolarisFileWrapper(r9.b).exists() == false) goto L16;
        return r9.b;
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r1 = false;
        goto L12
    L51:
        return r10.getPath();
    }

    public static Cursor W90(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public final View onCreateView(LayoutInflater r25, ViewGroup r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r25, "inflater");
        Context r1 = requireContext();
        FrameLayout r2 = new FrameLayout(r1);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.setBackgroundColor(0);
        r2.setClickable(true);
        r2.setOnClickListener(new b0(this));
        final LinearLayout r6 = c4.k(r1);
        r6.setClickable(true);
        r6.setPadding(c4.c(r1, 22), c4.c(r1, 10), c4.c(r1, 22), c4.c(r1, 22));
        GradientDrawable r7 = new GradientDrawable();
        r7.setColor(-1);
        r7.setCornerRadii(new float[]{c4.c(r1, 24), c4.c(r1, 24), c4.c(r1, 24), c4.c(r1, 24), 0.0f, 0.0f, 0.0f, 0.0f});
        r6.setBackground(r7);
        final int r9 = r6.getPaddingLeft();
        final int r10 = r6.getPaddingTop();
        final int r8 = r6.getPaddingRight();
        final int r11 = r6.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(r6, new w(r9, r10, r8, r11));
        ViewCompat.setWindowInsetsAnimationCallback(r6, new CocreationFeedbackPanelFragment$applyImeInsetsToPanel$2(r6, r9, r10, r8, r11));
        r6.post(new x(r6));
        Context r12 = requireContext();
        FrameLayout r13 = new FrameLayout(r12);
        View r14 = new View(r12);
        Intrinsics.checkNotNull(r12);
        r14.setBackground(c4.h(r12, -2500135, 2, 0, 0));
        r13.addView(r14, new FrameLayout.LayoutParams(c4.c(r12, 42), c4.c(r12, 4), 17));
        r13.setLayoutParams(new LinearLayout.LayoutParams(-1, c4.c(r12, 6)));
        c4.b(r6, r13, 0, 0, c4.c(r1, 8), 6);
        Context r5 = requireContext();
        Intrinsics.checkNotNull(r5);
        LinearLayout r15 = c4.e(r5);
        r15.setGravity(16);
        r15.addView(new View(r5), new LinearLayout.LayoutParams(c4.c(r5, 42), c4.c(r5, 42)));
        d5 r16 = this.d;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r16 = null;
    L5:
        TextView r17 = c4.f(r5, r16.b, 18.0f, -15656921, 1);
        r17.setGravity(17);
        r15.addView(r17, new LinearLayout.LayoutParams(0, -2, 1.0f));
        b r18 = new b(r5);
        r18.setContentDescription("关闭反馈面板");
        r18.setOnClickListener(new u(this));
        r15.addView(r18, new LinearLayout.LayoutParams(c4.c(r5, 42), c4.c(r5, 42)));
        c4.b(r6, r15, 0, 0, c4.c(r1, 16), 6);
        ScrollView r19 = new ScrollView(r1);
        r19.setOverScrollMode(1);
        r19.setFillViewport(false);
        LinearLayout r20 = c4.k(r1);
        d5 r110 = this.d;
        if (r110 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r110 = null;
    L8:
        c4.b(r20, c4.f(r1, r110.c, 13.0f, -9735552, 1), 0, 0, c4.c(r1, 10), 6);
        LinearLayout r111 = c4.k(r1);
        c4.b(r20, r111, 0, 0, c4.c(r1, 18), 6);
        this.k = r111;
        d5 r112 = this.d;
        if (r112 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r112 = null;
    L12:
        if (r112.m == false) goto L14;
        LinearLayout r3 = c4.k(r1);
        c4.b(r20, r3, 0, 0, c4.c(r1, 12), 6);
        this.p = r3;
    L14:
        Context r4 = requireContext();
        Intrinsics.checkNotNull(r4);
        StringBuilder r113 = new StringBuilder();
        r113.append(this.e.d.length());
        r113.append('/');
        d5 r114 = this.d;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r114 = null;
    L17:
        r113.append(r114.k);
        this.n = c4.f(r4, r113.toString(), 12.0f, -9735552, 1);
        LinearLayout r115 = c4.k(r4);
        r115.setPadding(c4.c(r4, 12), c4.c(r4, 11), c4.c(r4, 12), c4.c(r4, 10));
        r115.setBackground(c4.h(r4, -1, 16, -1973274, 1));
        EditText r21 = new EditText(r4);
        r21.setText(this.e.d);
        if (this.e.d.length() <= 0) goto L20;
        boolean r116 = true;
    L21:
        if (r116 == false) goto L23;
        r21.setSelection(this.e.d.length());
    L23:
        d5 r117 = this.d;
        if (r117 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r117 = null;
    L26:
        r21.setHint(r117.f);
        r21.setTextSize(13.5f);
        r21.setTextColor(-15656921);
        r21.setHintTextColor(-5721662);
        r21.setMinLines(2);
        r21.setMaxLines(4);
        InputFilter.LengthFilter[] r118 = new InputFilter.LengthFilter[1];
        d5 r119 = this.d;
        if (r119 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r119 = null;
    L29:
        r118[0] = new InputFilter.LengthFilter(r119.k);
        r21.setFilters(r118);
        r21.setInputType(131073);
        r21.setGravity(8388659);
        r21.setPadding(0, 0, 0, 0);
        d5 r120 = null;
        r21.setBackground(null);
        r21.setEnabled(!this.g);
        c4.d(r21);
        r21.addTextChangedListener(new r5(new g0(this)));
        this.o = r21;
        r115.addView(r21, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout r22 = c4.e(r4);
        r22.setGravity(16);
        StringBuilder r23 = new StringBuilder("不超过 ");
        d5 r121 = this.d;
        if (r121 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r121 = null;
    L32:
        r23.append(r121.k);
        r23.append(" 字");
        r22.addView(c4.f(r4, r23.toString(), 12.0f, -9735552, 0), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r24 = this.n;
        if (r24 == null) goto L44;
        r22.addView(r24);
        c4.b(r115, r22, 0, 0, 0, 14);
        c4.b(r20, r115, c4.c(r1, SpeechEvent.SERVER_UPLINK_EVENT_MUTE_CALL), 0, c4.c(r1, 12), 4);
        d5 r28 = this.d;
        if (r28 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("template");
        r28 = null;
    L37:
        TextView r29 = c4.f(r1, r28.j, 12.5f, -9735552, 0);
        this.m = r29;
        c4.b(r20, r29, 0, 0, c4.c(r1, 8), 6);
        r19.addView(r20, new ViewGroup.LayoutParams(-1, -2));
        r6.addView(r19, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        Context r30 = requireContext();
        Intrinsics.checkNotNull(r30);
        d5 r31 = this.d;
        if (r31 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("template");
    L41:
        TextView r32 = c4.f(r30, r120.h, 13.5f, -1, 1);
        r32.setGravity(17);
        r32.setOnClickListener(new v(this));
        this.l = r32;
        LinearLayout r33 = c4.e(r1);
        c4.b(r6, r33, c4.c(r1, 46), c4.c(r1, 12), 0, 8);
        this.q = r33;
        ba0();
        aa0();
        ea0();
        Z90();
        Resources r34 = r1.getResources();
        r2.addView(r6, new FrameLayout.LayoutParams(-1, (int) (WindowDisplayMetricsOverride.apply(r34, r34.getDisplayMetrics()).heightPixels * 0.54f), 80));
        return r2;
    L40:
        r120 = r31;
        goto L41
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        r116 = false;
        goto L21
    }

    public static final void V90(int r2, int r3, int r4, int r5, View r6, WindowInsetsCompat r7) {
        int r0 = r7.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r8 = RangesKt.coerceAtLeast(r7.getInsets(WindowInsetsCompat.Type.ime()).bottom - r0, 0);
        r6.setPadding(r2, r3, r4, r5 + r0);
        r6.setTranslationY(-r8);
    }
}
