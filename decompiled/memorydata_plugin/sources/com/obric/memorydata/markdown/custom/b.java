package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/markdown/custom/CustomUriSpan;", "Landroid/text/style/ClickableSpan;", EventBody.KEY_VALUE, "", "textColor", "", "bold", "", "underlineMeta", "Lcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;", WsConstants.KEY_EXTRA, "", "clickHandler", "Lcom/obric/memorydata/markdown/custom/LinkClickHandler;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ZLcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;Ljava/util/Map;Lcom/obric/memorydata/markdown/custom/LinkClickHandler;)V", "Ljava/lang/Integer;", "getUnderlineMeta", "()Lcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "onClick", "widget", "Landroid/view/View;", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9981b;
    private final Integer c;
    private final boolean d;
    private final l e;
    private final Map<String, String> f;
    private final d g;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f2*\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/markdown/custom/CustomUriSpan$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/markdown/custom/CustomUriSpan;", EventBody.KEY_VALUE, "", "underlineMeta", "Lcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;", "textColor", "", "bold", "", WsConstants.KEY_EXTRA, "", "onClick", "Lkotlin/Function3;", "Landroid/content/Context;", "", "(Ljava/lang/String;Lcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;Ljava/lang/Integer;ZLjava/util/Map;Lkotlin/jvm/functions/Function3;)Lcom/obric/memorydata/markdown/custom/CustomUriSpan;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9980a = new a(null);
    }

    public b(String r3, Integer r4, boolean r5, l r6, Map<String, String> r7, d r8) {
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, "underlineMeta");
        Intrinsics.checkNotNullParameter(r9, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r10, "clickHandler");
        this.f9981b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r9;
        this.g = r10;
    }

    public /* synthetic */ b(String r8, Integer r9, boolean r10, l r11, Map r12, d r13, int r14, DefaultConstructorMarker r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.memorydata.plugin");
        if ((r14 & 2) == 0) goto L5;
        r9 = null;
    L5:
        Integer r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r10 = false;
    L8:
        boolean r3 = r10;
        if ((r14 & 16) == 0) goto L11;
        r16 = MapsKt.emptyMap();
    L11:
        this(r8, r2, r3, r11, r16, r6);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        d r1 = this.g;     // Catch: Throwable -> L5
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");     // Catch: Throwable -> L5
        r1.a(r5, this.f9981b, this.f);     // Catch: Throwable -> L5
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r4) {
        Intrinsics.checkNotNullParameter(r4, "tp");
        Integer r0 = this.c;
        if (r0 == null) goto L5;
        r4.setColor(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue());
    L5:
        r4.setUnderlineText(false);
        r4.setFakeBoldText(this.d);
        if (this.d == false) goto L8;
        Typeface r3 = Typeface.create(r4.getTypeface(), 1);
    L9:
        r4.setTypeface(r3);
        return;
    L8:
        r3 = r4.getTypeface();
        goto L9
    }
}
