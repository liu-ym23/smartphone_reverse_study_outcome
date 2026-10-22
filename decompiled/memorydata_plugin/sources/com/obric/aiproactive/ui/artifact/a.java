package com.obric.aiproactive.ui.artifact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.api.AiProactiveArtifactState;
import com.obric.aiproactive.api.AiProactiveArtifactType;
import com.obric.aiproactive.api.j;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ0\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000fJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0002J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J\f\u0010\u0018\u001a\u00020\u0005*\u00020\u0012H\u0002J\u0014\u0010\u0019\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010\u001c\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001d\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0015\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b$J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0015\u0010(\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0014\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u00020/H\u0002R\u000e\u00102\u001a\u000203X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/ArtifactListRenderer;", "", "<init>", "()V", "bind", "", "container", "Landroid/widget/LinearLayout;", "artifacts", "", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "bindReferences", "references", "Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "canonicalArtifacts", "", "", "createItem", "Lcom/obric/oui/lisitem/OCardListItem;", "parent", "Landroid/view/ViewGroup;", "artifact", "createReferenceItem", "canonicalArtifact", "flattenOUIGroupInsets", "applyArtifactOutline", "ready", "", "applyArtifactTitleStyle", "applyArtifactTypeIcon", "buildSubtitle", "buildSubtitle$ai_proactive_ui_obricRelease", "buildAccessibilityLabel", "opensInDocumentPreview", "buildAccessibilityLabel$ai_proactive_ui_obricRelease", "buildReferenceAccessibilityLabel", "buildReferenceAccessibilityLabel$ai_proactive_ui_obricRelease", "referenceStateText", "state", "Lcom/obric/aiproactive/api/AiProactiveArtifactState;", "formatShortName", "formatShortName$ai_proactive_ui_obricRelease", "formatSize", "sizeBytes", "", "formatSize$ai_proactive_ui_obricRelease", "dp", "", "Landroid/view/View;", EventBody.KEY_VALUE, "DISABLED_CONTENT_ALPHA", "", "TITLE_MAX_LINES", "SAFE_EXTENSION", "Lkotlin/text/Regex;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6543b = null;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0291a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6544a = null;

        static {
            int[] r0 = new int[AiProactiveArtifactState.values().length];
            r0[AiProactiveArtifactState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[AiProactiveArtifactState.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[AiProactiveArtifactState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[AiProactiveArtifactState.EXPIRED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[AiProactiveArtifactState.CANCELLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f6544a = r0;
        }
    }

    static {
        f6542a = new a();
        f6543b = new Regex("[A-Za-z0-9]{1,4}");
    }

    private a() {
    }

    private final int a(View r1, int r2) {
        return (int) (r2 * ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    private final OCardListItem a(ViewGroup r10, final j r11) {
        boolean r9 = r11.h();
        boolean r0 = b.f6545a.a(r11);
        final Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r12);
        OCardListItem r8 = new OCardListItem(r12, null, 0, 6, null);
        r8.setMinimumHeight(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_artifact_item_min_height, "dimen", "proactive_artifact_item_min_height")));
        r8.setImportantForAccessibility(1);
        a r3 = f6542a;
        r8.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(r11, r0), CharSequence.class, "com.obric.memorydata.plugin"));
        r8.setCardType(0);
        View.OnClickListener r5 = null;
        OCardListItem.a(r8, 0, false, 2, null);
        r8.setShowCardBg(true);
        r3.a(r8);
        r3.a(r8, r9);
        r3.a(r8, r11, r9);
        r8.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r11.d(), CharSequence.class, "com.obric.memorydata.plugin"));
        r8.c(true);
        r3.b(r8, r9);
        r8.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(r11), CharSequence.class, "com.obric.memorydata.plugin"));
        r8.d(true);
        r8.e(false);
        r8.f(r9);
        if (r9 == false) goto L5;
        r8.setDefaultTailIcon(0);
    L5:
        r8.setEnabled(r9);
        r8.setAlpha(1.0f);
        if (r9 == false) goto L8;
        r5 = new $$Lambda$a$cbzUEzsvyFqeZZmDspnmDmlQys4(r12, r11);
    L8:
        r8.setOnContentClickListener(r5);
        return r8;
    }

    private final OCardListItem a(ViewGroup r11, j r12, final j r13) {
        if (r13 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        final Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r14);
        OCardListItem r9 = new OCardListItem(r14, null, 0, 6, null);
        r9.setMinimumHeight(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_artifact_item_min_height, "dimen", "proactive_artifact_item_min_height")));
        r9.setImportantForAccessibility(1);
        a r3 = f6542a;
        r9.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(r12, r1), CharSequence.class, "com.obric.memorydata.plugin"));
        r9.setCardType(0);
        View.OnClickListener r5 = null;
        OCardListItem.a(r9, 0, false, 2, null);
        r9.setShowCardBg(true);
        r3.a(r9);
        r3.a(r9, r1);
        r3.a(r9, r12, r1);
        r9.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r12.d(), CharSequence.class, "com.obric.memorydata.plugin"));
        r9.c(true);
        r3.b(r9, r1);
        r9.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(r12.c(), r1), CharSequence.class, "com.obric.memorydata.plugin"));
        r9.d(true);
        r9.e(false);
        r9.f(r1);
        if (r1 == false) goto L11;
        r9.setDefaultTailIcon(0);
    L11:
        r9.setEnabled(r1);
        r9.setAlpha(1.0f);
        if (r13 != null) goto L14;
    L19:
        r9.setOnContentClickListener(r5);
        return r9;
    L14:
        if (Boolean.valueOf(r13.h()).booleanValue() == true) goto L17;
        r13 = null;
    L17:
        if (r13 == null) goto L19;
        r5 = new $$Lambda$a$VhIo5Nas8SYPXYmcBEmrt8xYAik(r14, r13);
        goto L19
    L5:
        if (r13.h() != true) goto L7;
        r1 = true;
        goto L8
    }

    private final String a(AiProactiveArtifactState r2, boolean r3) {
        if (r2 != AiProactiveArtifactState.READY) goto L7;
        if (r3 == false) goto L7;
        return "已就绪";
    L7:
        if (r2 != AiProactiveArtifactState.READY) goto L10;
        return "内容暂时无法打开";
    L10:
        if (r2 != AiProactiveArtifactState.PENDING) goto L13;
        return "正在准备";
    L13:
        if (r2 != AiProactiveArtifactState.FAILED) goto L16;
        return "内容暂时无法打开";
    L16:
        if (r2 != AiProactiveArtifactState.EXPIRED) goto L18;
        return "内容已失效";
    L18:
        return "已取消";
    }

    private static final void a(Context r8, j r9, View r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r10);
        LifecycleOwner r12 = ViewTreeLifecycleOwner.get(r10);
        if (r12 == null) goto L8;
        LifecycleCoroutineScope r13 = LifecycleOwnerKt.getLifecycleScope(r12);
        if (r13 == null) goto L9;
        i.a((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ArtifactListRenderer$createItem$1$1$1(r11, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L9:
        return;
    }

    private final void a(OCardListItem r7) {
        FrameLayout r0 = r7.getCardContainer();
        ViewGroup.MarginLayoutParams r1 = null;
        r0.setBackground(null);
        r0.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L5:
        if (r1 == null) goto L7;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L7:
        r7.getContentContainer().setPaddingRelative(a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 12), 0, a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 4), 0);
    }

    private final void a(OCardListItem r7, j r8, boolean r9) {
        int r0 = a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 40);
        int r6 = a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 12);
        int r2 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_image_size_m1, "dimen", "oui_image_size_m1"));
        FrameLayout r3 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.setLayoutParams(new ViewGroup.LayoutParams(r6 + r0, r0));
        ImageView r10 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r10.setImageResource(ArtifactFileIconResolver.f6533a.a(r8));
        r10.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r10.setContentDescription(null);
        if (r9 == false) goto L5;
        float r11 = 1.0f;
    L6:
        r10.setAlpha(r11);
        View r12 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r2, r2, 8388627);
        r13.setMarginStart((r0 - r2) / 2);
        Unit r14 = Unit.INSTANCE;
        r3.addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r7.b(false);
        r7.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        r7.a(true);
        return;
    L5:
        r11 = 0.62f;
        goto L6
    }

    private final void a(OCardListItem r5, boolean r6) {
        OUICardConstraintLayout r4 = r5.getContentContainer();
        r4.setMinimumHeight(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_artifact_item_min_height, "dimen", "proactive_artifact_item_min_height")));
        r4.setRadius(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_image_radius_l2, "dimen", "oui_image_radius_l2")));
        r4.setBorderWidth(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_image_stroke_width, "dimen", "oui_image_stroke_width")));
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L5;
        int r8 = R.color.oui_basic_line_2;
        String r1 = "oui_basic_line_2";
    L6:
        r4.setBorderColor(r7.getColor(ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_COLOR, r1)));
        return;
    L5:
        r8 = R.color.oui_basic_line_2_opaque;
        r1 = "oui_basic_line_2_opaque";
        goto L6
    }

    private static final void b(Context r8, j r9, View r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r10);
        LifecycleOwner r12 = ViewTreeLifecycleOwner.get(r10);
        if (r12 == null) goto L8;
        LifecycleCoroutineScope r13 = LifecycleOwnerKt.getLifecycleScope(r12);
        if (r13 == null) goto L9;
        i.a((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ArtifactListRenderer$createReferenceItem$1$2$1$1(r11, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L9:
        return;
    }

    private final void b(OCardListItem r3, boolean r4) {
        OTextView r2 = r3.getTitleView();
        r2.setMaxLines(2);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        if (r4 == true) goto L6;
        r2.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        return;
    }

    public static /* synthetic */ void lambda$VhIo5Nas8SYPXYmcBEmrt8xYAik(Context r0, j r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$cbzUEzsvyFqeZZmDspnmDmlQys4(Context r0, j r1, View r2) {
        a(r0, r1, r2);
    }

    public final String a(long r10) {
        if (r10 >= 1024) goto L7;
        StringBuilder r9 = new StringBuilder().append(r10).append(" B");
    L6:
        return r9.toString();
    L7:
        String[] r11 = {"KB", "MB", "GB"};
        double r12 = r10;
        int r0 = -1;
    L9:
        if (r12 < 1024.0d) goto L14;
        if (r0 >= ArraysKt.getLastIndex(r11)) goto L14;
        r12 = r12 / 1024.0d;
        r0 = r0 + 1;
    L14:
        if (r12 < 10.0d) goto L16;
    L22:
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r13 = String.format(Locale.ROOT, "%.0f", Arrays.copyOf(new Object[]{Double.valueOf(r12)}, 1));
    L23:
        Intrinsics.checkNotNullExpressionValue(r13, "format(...)");
        r9 = new StringBuilder().append(r13).append(' ').append(r11[r0]);
        goto L6
    L16:
        if ((r12 % 1.0d) != 0.0d) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L22;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        r13 = String.format(Locale.ROOT, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r12)}, 1));
        goto L23
    L18:
        r2 = false;
        goto L19
    }

    public final String a(j r11) {
        Intrinsics.checkNotNullParameter(r11, "artifact");
        String r0 = b(r11);
        AiProactiveArtifactState r1 = r11.c();
        int r2 = C0291a.f6544a[r1.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L6;
        StringBuilder r10 = new StringBuilder().append(r0);
        String r12 = " · 正在准备";
    L24:
        return r10.append(r12).toString();
    L6:
        if (r2 != 3) goto L8;
        r10 = new StringBuilder().append(r0);
        r12 = " · 内容暂时无法打开";
        goto L24
    L8:
        if (r2 != 4) goto L10;
        r10 = new StringBuilder().append(r0);
        r12 = " · 内容已失效";
        goto L24
    L10:
        if (r2 != 5) goto L13;
        r10 = new StringBuilder().append(r0);
        r12 = " · 已取消";
        goto L24
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        String[] r3 = new String[2];
        r3[0] = r0;
        Long r13 = r11.g();
        if (r13 == null) goto L21;
        String r14 = a(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue());
    L22:
        r3[1] = r14;
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r3), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L21:
        r14 = null;
        goto L22
    }

    public final String a(j r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "artifact");
        if (r3.h() == true) goto L5;
        String r5 = "";
    L9:
        return r3.d() + 65292 + a(r3) + r5;
    L5:
        if (r4 == false) goto L7;
        r5 = "，点按预览";
        goto L9
    L7:
        r5 = "，点按使用其他应用打开";
        goto L9
    }

    public final void a(LinearLayout r10, List<j> r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r9, "artifacts");
        r10.removeAllViews();
        if (r9.isEmpty() == false) goto L5;
        int r12 = 8;
    L6:
        r10.setVisibility(r12);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L17;
        Object r3 = r13.next();
        int r4 = r14 + 1;
        if (r14 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        j r5 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");
        a r6 = f6542a;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.a((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin"), r5), View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        if (r14 != 0) goto L15;
        int r15 = 0;
    L16:
        r8.topMargin = r15;
        Unit r16 = Unit.INSTANCE;
        r10.addView(r7, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r14 = r4;
        goto L8
    L15:
        r15 = r6.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), 8);
        goto L16
    L17:
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final void a(LinearLayout r25, List<com.obric.aiproactive.api.d> r26, Map<String, j> r27) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r25, "container");
        Intrinsics.checkNotNullParameter(r1, "references");
        Intrinsics.checkNotNullParameter(r3, "canonicalArtifacts");
        r25.removeAllViews();
        if (r1.isEmpty() == false) goto L5;
        int r4 = 8;
    L6:
        r25.setVisibility(r4);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L8:
        if (r2.hasNext() == false) goto L33;
        Object r7 = r2.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.obric.aiproactive.api.d r9 = (com.obric.aiproactive.api.d) ZeusTransformUtils.preCheckCast(r7, com.obric.aiproactive.api.d.class, "com.obric.memorydata.plugin");
        j r10 = (j) ZeusTransformUtils.preCheckCast(r3.get(r9.a()), j.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L15;
    L24:
        r10 = null;
    L25:
        if (r10 != null) goto L27;
        j r11 = new j(r9.a(), r9.b(), r9.d(), r9.c(), "", null, null, null, null, null, 992, null);
    L28:
        a r12 = f6542a;
        View r13 = (View) ZeusTransformUtils.preCheckCast(r12.a((ViewGroup) ZeusTransformUtils.preCheckCast(r25, ViewGroup.class, "com.obric.memorydata.plugin"), r11, r10), View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -2);
        if (r5 != 0) goto L31;
        int r6 = 0;
    L32:
        r14.topMargin = r6;
        Unit r15 = Unit.INSTANCE;
        r25.addView(r13, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r5 = r8;
        goto L8
    L31:
        r6 = r12.a((View) ZeusTransformUtils.preCheckCast(r25, View.class, "com.obric.memorydata.plugin"), 8);
        goto L32
    L27:
        r11 = r10;
        goto L28
    L15:
        if (r10.b() == r9.b()) goto L17;
    L21:
        boolean r16 = false;
    L22:
        if (r16 == false) goto L24;
    L17:
        if (Intrinsics.areEqual(r10.d(), r9.c()) == false) goto L21;
        if (r10.c() != r9.d()) goto L21;
        r16 = true;
        goto L22
    L33:
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final String b(j r6) {
        Intrinsics.checkNotNullParameter(r6, "artifact");
        String r5 = StringsKt.substringAfterLast(r6.d(), '.', "");
        if (f6543b.matches((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        Locale r7 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r7, "ROOT");
        String r8 = r5.toUpperCase(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "toUpperCase(...)");
        return r8;
    L6:
        String r9 = r6.e();
        Locale r0 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r0, "ROOT");
        String r10 = r9.toLowerCase(r0);
        Intrinsics.checkNotNullExpressionValue(r10, "toLowerCase(...)");
        if (Intrinsics.areEqual(r10, "application/pdf") == false) goto L10;
        return "PDF";
    L10:
        if (StringsKt.startsWith$default(r10, "image/", false, 2, null) == false) goto L12;
    L33:
        return "IMG";
    L12:
        if (r6.b() == AiProactiveArtifactType.IMAGE) goto L33;
        if (StringsKt.startsWith$default(r10, "video/", false, 2, null) == false) goto L17;
    L32:
        return "VID";
    L17:
        if (r6.b() == AiProactiveArtifactType.VIDEO) goto L32;
        if (StringsKt.startsWith$default(r10, "audio/", false, 2, null) == false) goto L22;
    L31:
        return "AUD";
    L22:
        if (r6.b() == AiProactiveArtifactType.AUDIO) goto L31;
        if (StringsKt.startsWith$default(r10, "text/", false, 2, null) == false) goto L28;
        return "TXT";
    L28:
        if (r6.b() != AiProactiveArtifactType.LINK) goto L30;
        return "LINK";
    L30:
        return "FILE";
    }

    public final String b(j r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "artifact");
        StringBuilder r2 = new StringBuilder().append(r3.d()).append(65292).append(b(r3)).append(" · ").append(a(r3.c(), r4));
        if (r4 == false) goto L5;
        String r5 = "，点按打开";
    L7:
        return r2.append(r5).toString();
    L5:
        r5 = "";
        goto L7
    }
}
