package com.larus.business.markdown.impl.markwon.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.api.c;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.m;
import io.noties.markwon.html.a.d;
import io.noties.markwon.html.a.e;
import io.noties.markwon.html.a.f;
import io.noties.markwon.html.a.g;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TBw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0018\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0017H\u0016J\u0018\u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0017H\u0002JR\u00103\u001a\u00020.2\u0006\u00104\u001a\u0002052\b\u00101\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020?H\u0016J8\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0002J4\u0010E\u001a\u00020\n2\u0006\u0010>\u001a\u00020?2\b\u00101\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0017H\u0002J\b\u0010I\u001a\u00020\u0004H\u0002J\b\u0010J\u001a\u00020\u0013H\u0002J\b\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010L\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u0010M\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u0010N\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J\"\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001062\u0006\u0010Q\u001a\u00020\nH\u0002J$\u0010R\u001a\u00020.2\u0006\u0010\f\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0010\u0010S\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0002R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataPlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "dataType", "", "dataValue", "dataValueId", "dataExtra", "dataTag", "startIndex", "", "endIndex", "maxContentWidth", "dataHandler", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "payload", "", "", "forbiddenLeadingMargin", "", "needRefresh", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/larus/business/markdown/api/depend/ICustomDataHandler;Ljava/util/Map;ZZ)V", "attachedSpanned", "Landroid/text/Spanned;", "attachedTextView", "Landroid/widget/TextView;", "getDataExtra", "()Ljava/lang/String;", "getDataTag", "getDataType", "getDataValue", "getDataValueId", "debugRect", "Landroid/graphics/Rect;", "getEndIndex$markdown_impl_release", "()I", "getNeedRefresh", "()Z", "setNeedRefresh", "(Z)V", "size", "Landroid/util/Size;", "getStartIndex$markdown_impl_release", "widget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "afterAttach", "", "textView", "beforeAttach", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "beforeAttachCacheWidget", "draw", "canvas", "Landroid/graphics/Canvas;", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawDebugRect", "left", "width", "height", TypedValues.Custom.S_COLOR, "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSpanWidth", "getValueId", "isForbiddenPaddingAndMargin", "isUseCacheWidget", "onDetach", "onRecycle", "onReuse", "printLog", "log", "index", "updateConfig", "updateTextViewPadding", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends ReplacementSpan implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0217a f5187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5188b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;
    private int i;
    private final com.larus.business.markdown.api.depend.a j;
    private Map<String, ? extends Object> k;
    private final boolean l;
    private boolean m;
    private TextView n;
    private Spanned o;
    private g p;
    private Size q;
    private final Rect r;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataPlaceholderSpan$Companion;", "", "()V", "LOG_TAG", "", "PAY_LOAD_KEY_FULL_BLOCK", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0217a {
        private C0217a() {
        }

        public /* synthetic */ C0217a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5187a = new C0217a(null);
    }

    public a(String r3, String r4, String r5, String r6, String r7, int r8, int r9, int r10, com.larus.business.markdown.api.depend.a r11, Map<String, ? extends Object> r12, boolean r13, boolean r14) {
        com.larus.business.markdown.api.depend.a r15 = (com.larus.business.markdown.api.depend.a) ZeusTransformUtils.wrapperContextForParams(r11, com.larus.business.markdown.api.depend.a.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dataType");
        Intrinsics.checkNotNullParameter(r4, "dataValue");
        Intrinsics.checkNotNullParameter(r5, "dataValueId");
        Intrinsics.checkNotNullParameter(r7, "dataTag");
        Intrinsics.checkNotNullParameter(r15, "dataHandler");
        this.f5188b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r15;
        this.k = r16;
        this.l = r13;
        this.m = r14;
        this.q = new Size(0, 0);
        this.r = new Rect();
    }

    public /* synthetic */ a(String r16, String r17, String r18, String r19, String r20, int r21, int r22, int r23, com.larus.business.markdown.api.depend.a r24, Map r25, boolean r26, boolean r27, int r28, DefaultConstructorMarker r29) {
        com.larus.business.markdown.api.depend.a r11 = (com.larus.business.markdown.api.depend.a) ZeusTransformUtils.wrapperContextForParams(r24, com.larus.business.markdown.api.depend.a.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        if ((r28 & 2048) == 0) goto L5;
        boolean r14 = false;
    L6:
        this(r16, r17, r18, r19, r20, r21, r22, r23, r11, r12, r26, r14);
        return;
    L5:
        r14 = r27;
        goto L6
    }

    private final int a(Spanned r3) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        if (h() == false) goto L13;
        int r5 = this.i;
        TextView r0 = this.n;
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = r0.getPaddingStart();
    L8:
        int r6 = r5 + r2;
        TextView r7 = this.n;
        if (r7 == null) goto L17;
        r1 = r7.getPaddingEnd();
    L17:
        return r6 + r1;
    L7:
        r2 = 0;
        goto L8
    L13:
        if (this.l == false) goto L16;
        return this.i;
    L16:
        return this.i - c.a(r4, this.g);
    }

    private static final void a(a r2, Ref.IntRef r3, CharSequence r4, int r5, View r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$newTop");
        Intrinsics.checkNotNullParameter(r6, "$widgetView");
        r2.a("post show image marginTop " + r3.element, r7, r5);
        r6.setVisibility(0);
    }

    private final void a(String r1, CharSequence r2, int r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void b(TextView r22, Spanned r23) {
        Spanned r1 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r23, Spanned.class, "com.obric.memorydata.plugin");
        ViewParent r3 = r22.getParent();
        ViewGroup r9 = null;
        if (ZeusTransformUtils.instanceOf(r3, FrameLayout.class) == false) goto L5;
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r22, com.larus.business.markdown.api.c.a.a.class) == false) goto L28;
        if (r10 == null) goto L28;
        String r20 = j();
        g r12 = d.f16557a.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), this.g, this.h, a(), b(), r20, d());
        if (r12 == null) goto L26;
        this.q = r12.a(r22, r1, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), a(r1), this.k);
        a("span calc cache: " + this.q.getWidth() + ", " + this.q.getHeight(), r22.getText(), this.g);
        this.p = r12;
        View r2 = r12.a();
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4.width == this.q.getWidth()) goto L15;
    L16:
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        if (r5 == null) goto L25;
        r5.width = this.q.getWidth();
        r5.height = -2;
        r2.setLayoutParams(r5);
    L19:
        ViewParent r0 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L22;
        r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
    L22:
        if (r9 == null) goto L27;
        r9.removeView(r2);
    L27:
        r10.addView(r2);
        return;
    L25:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        if (r4.height == this.q.getHeight()) goto L19;
    L26:
        g r11 = this.j.a(r10, r22, r1, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), this.k);
        this.q = r11.a(r22, r1, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), a(r1), this.k);
        a("span calc new__: " + this.q.getWidth() + ", " + this.q.getHeight(), r22.getText(), this.g);
        r2 = r11.a();
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(this.q.getWidth(), -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r2.setVisibility(4);
        this.p = r11;
        d.f16557a.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), this.g, this.h, a(), b(), r20, d(), r11);
    L28:
        this.p = null;
        return;
    L5:
        r10 = null;
        goto L7
    }

    private final void d(TextView r9) {
        Object r0 = r9.getTag(ZeusTransformUtils.mapRes(R.id.textview_padding_start, OaidModel.KEY_ID, "textview_padding_start"));
        Integer r4 = null;
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L5;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L28;
        int r2 = r1.intValue();
        Object r3 = r9.getTag(ZeusTransformUtils.mapRes(R.id.textview_padding_top, OaidModel.KEY_ID, "textview_padding_top"));
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L10;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
    L11:
        if (r5 == null) goto L29;
        int r6 = r5.intValue();
        Object r7 = r9.getTag(ZeusTransformUtils.mapRes(R.id.textview_padding_end, OaidModel.KEY_ID, "textview_padding_end"));
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L15;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin");
    L16:
        if (r8 == null) goto L30;
        int r10 = r8.intValue();
        Object r11 = r9.getTag(ZeusTransformUtils.mapRes(R.id.textview_padding_bottom, OaidModel.KEY_ID, "textview_padding_bottom"));
        if (ZeusTransformUtils.instanceOf(r11, Integer.class) == false) goto L20;
        r4 = (Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.memorydata.plugin");
    L20:
        if (r4 == null) goto L31;
        int r12 = r4.intValue();
        if (Intrinsics.areEqual(d(), "data-block-full") == false) goto L25;
        this.i += r2 + r10;
        r9.setPadding(0, 0, 0, 0);
        return;
    L25:
        if (r9.getPaddingStart() != 0) goto L33;
        r9.setPadding(r2, r6, r10, r12);
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L15:
        r8 = null;
        goto L16
    L29:
        return;
    L10:
        r5 = null;
        goto L11
    L28:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final boolean h() {
        if (Intrinsics.areEqual(a(), "mixed_media_card") == true) goto L9;
        if (Intrinsics.areEqual(a(), "creation") == true) goto L9;
        if (Intrinsics.areEqual(a(), "vlm_mixed_media_card") == true) goto L9;
    L11:
        return false;
    L9:
        if (this.l == false) goto L11;
        return true;
    }

    private final boolean i() {
        if (com.larus.business.markdown.api.depend.b.a(a()) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(a(), "applet") == true) goto L10;
        if (Intrinsics.areEqual(a(), "search_reference") == true) goto L10;
        return false;
    }

    private final String j() {
        if (Intrinsics.areEqual(a(), "search_reference") == false) goto L9;
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(c(), CharSequence.class, "com.obric.memorydata.plugin"), "_", 0, false, 6, null);
        if (r0 == (-1)) goto L9;
        StringBuilder r1 = new StringBuilder();
        String r2 = c();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r3 = r2.substring(0, r0 + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r1.append(r3).append(this.g).toString();
    L9:
        return c();
    }

    public static /* synthetic */ void lambda$vpEYaXjtnu8801ibV4fLUhNmOqQ(a r0, Ref.IntRef r1, CharSequence r2, int r3, View r4) {
        a(r0, r1, r2, r3, r4);
    }

    public String a() {
        return this.f5188b;
    }

    public final void a(int r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.i = r3;
        this.k = r5;
    }

    @Override // io.noties.markwon.html.a.f
    public void a(TextView r4) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        g r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        Size r5 = r0.a(r4, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), this.k);
        if (r5 != null) goto L8;
        return;
    L8:
        this.q = r5;
        View r6 = r0.a();
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.width == this.q.getWidth()) goto L14;
    L15:
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L20;
        r2.width = this.q.getWidth();
        r2.height = this.q.getHeight();
        r6.setLayoutParams(r2);
        return;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (r1.height != this.q.getHeight()) goto L15;
    }

    @Override // io.noties.markwon.html.a.f
    public void a(TextView r11, Spanned r12) {
        Spanned r13 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r12, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "textView");
        Intrinsics.checkNotNullParameter(r13, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.n = r11;
        this.o = r13;
        d(r11);
        if (i() == false) goto L5;
        b(r11, r13);
        return;
    L5:
        ViewParent r0 = r11.getParent();
        if (ZeusTransformUtils.instanceOf(r0, FrameLayout.class) == false) goto L8;
        FrameLayout r1 = (FrameLayout) ZeusTransformUtils.preCheckCast(r0, FrameLayout.class, "com.obric.memorydata.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r11, com.larus.business.markdown.api.c.a.a.class) == false) goto L26;
        if (r1 == null) goto L26;
        g r8 = e.a((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin"), this.g, this.h, a(), b(), c());
        if (r8 == null) goto L24;
        this.q = r8.a(r11, r13, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), a(r13), this.k);
        a("span calc cache: " + this.q.getWidth() + ", " + this.q.getHeight(), r11.getText(), this.g);
        this.p = r8;
        View r14 = r8.a();
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15.width == this.q.getWidth()) goto L18;
    L19:
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16 == null) goto L23;
        r16.width = this.q.getWidth();
        r16.height = this.q.getHeight();
        r14.setLayoutParams(r16);
    L25:
        r1.addView(r14);
        return;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        if (r15.height == this.q.getHeight()) goto L25;
    L24:
        g r9 = this.j.a(r1, r11, r13, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), this.k);
        this.q = r9.a(r11, r13, (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin"), a(r13), this.k);
        a("span calc new__: " + this.q.getWidth() + ", " + this.q.getHeight(), r11.getText(), this.g);
        r14 = r9.a();
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(this.q.getWidth(), this.q.getHeight()), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r14.setVisibility(4);
        this.p = r9;
    L26:
        this.p = null;
        return;
    L8:
        r1 = null;
        goto L10
    }

    public String b() {
        return this.c;
    }

    @Override // io.noties.markwon.html.a.f
    public void b(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        a("span afterAttach", r3.getText(), this.g);
    }

    public String c() {
        return this.d;
    }

    @Override // io.noties.markwon.html.a.f
    public void c(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        g r6 = this.p;
        if (r6 == null) goto L12;
        View r7 = r6.a();
        if (r7 == null) goto L12;
        ViewParent r1 = r7.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L9;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
        r2.removeView(r7);
        goto L12
    L9:
        r2 = null;
    L12:
        this.n = null;
        a("span detach", null, 0);
    }

    public String d() {
        return this.f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r22, CharSequence r23, final int r24, int r25, float r26, int r27, int r28, int r29, Paint r30) {
        final CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "canvas");
        Intrinsics.checkNotNullParameter(r30, "paint");
        TextView r10 = this.n;
        if (r10 != null) goto L5;
        return;
    L5:
        g r9 = this.p;
        if (r9 != null) goto L8;
        return;
    L8:
        final View r8 = r9.a();
        ViewGroup.MarginLayoutParams r16 = null;
        if (ZeusTransformUtils.instanceOf(r15, SpannableString.class) == false) goto L11;
        SpannableString r1 = (SpannableString) ZeusTransformUtils.preCheckCast(r15, SpannableString.class, "com.obric.memorydata.plugin");
    L12:
        if (r1 == null) goto L17;
        Object[] r2 = ((Spanned) ZeusTransformUtils.preCheckCast(r1, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r24, r25, m.class);
        Intrinsics.checkExpressionValueIsNotNull(r2, "getSpans(start, end, T::class.java)");
        m[] r3 = (m[]) ZeusTransformUtils.preCheckCast(r2, m[].class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L17;
        m r4 = (m) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r3), m.class, "com.obric.memorydata.plugin");
    L18:
        if (r4 == null) goto L20;
        float r5 = r4.a();
    L21:
        r8.setAlpha(r5 / 255);
        final Ref.IntRef r6 = new Ref.IntRef();
        r6.element = (r27 + r10.getTop()) + r10.getPaddingTop();
        if (h() == false) goto L27;
        int r7 = r10.getLeft();
    L25:
        int r17 = r7;
        Integer r20 = r9.a(this.q, r10, r22, r15, r24, r25, r26, r27, r28, r29, r30);
        Integer r11 = r9.b(this.q, r10, r22, r15, r24, r25, r26, r27, r28, r29, r30);
        if (r20 == null) goto L33;
        r6.element += r20.intValue();
    L33:
        if (r11 == null) goto L35;
        r17 = r17 + r11.intValue();
    L35:
        int r12 = r17;
        ViewGroup.LayoutParams r13 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == false) goto L38;
        r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L38:
        ViewGroup.MarginLayoutParams r14 = r16;
        if (r14 == null) goto L46;
        if (r14.topMargin == r6.element) goto L43;
    L44:
        ViewGroup.LayoutParams r18 = r8.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r19 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r21.topMargin = r6.element;
        r21.leftMargin = r12;
        r8.setLayoutParams(r19);
        r8.setVisibility(4);
        r8.post(new $$Lambda$a$vpEYaXjtnu8801ibV4fLUhNmOqQ(this, r6, r15, r24, r8));
        return;
    L43:
        if (r14.leftMargin != r12) goto L44;
    L46:
        if (r8.getVisibility() == 0) goto L48;
        a("span just show image marginTop " + r6.element, r15, r24);
        r8.setVisibility(0);
        return;
    L48:
        a("span already show image marginTop " + r6.element, r15, r24);
        return;
    L27:
        if (this.l == false) goto L29;
        r7 = r10.getLeft() + r10.getPaddingLeft();
        goto L25
    L29:
        r7 = (((int) r26) + r10.getLeft()) + r10.getPaddingLeft();
        goto L25
    L20:
        r5 = 255.0f;
    L17:
        r4 = null;
        goto L18
    L11:
        r1 = null;
        goto L12
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public boolean g() {
        return this.m;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "paint");
        int r9 = 0;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L10;
    L9:
        int r11 = this.q.getHeight();
    L13:
        if (r7 == null) goto L15;
        r7.ascent = -r11;
        r7.descent = 0;
        r7.top = r7.ascent;
        r7.bottom = 0;
    L15:
        a("span_size, get: " + this.q.getWidth() + ", " + r11, r8, r5);
        int r12 = this.i;
        Spanned r13 = this.o;
        if (r13 == null) goto L19;
        r9 = c.a(r13, this.g);
    L19:
        return Math.min(r12 - r9, this.q.getWidth());
    L10:
        TextView r14 = this.n;
        if (r14 == null) goto L9;
        r11 = (int) ((this.q.getHeight() - r14.getLineSpacingExtra()) / r14.getLineSpacingMultiplier());
        goto L13
    L5:
        if (r8.length() != r6) goto L7;
        r10 = true;
        goto L8
    }
}
