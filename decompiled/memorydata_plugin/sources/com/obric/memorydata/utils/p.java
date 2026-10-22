package com.obric.memorydata.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/utils/CustomClickableSpan;", "Landroid/text/style/ClickableSpan;", "keyword", "", "linkStyle", "Lcom/obric/memorydata/utils/LinkStyle;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/utils/LinkStyle;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ad f13258b;

    public p(String r2, ad r3) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "linkStyle");
        this.f13257a = r2;
        this.f13258b = r3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "widget");
        ag r1 = this.f13258b.e();
        if (r1 != null) goto L21;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        return;
    L12:
        e r5 = this.f13258b.b();     // Catch: Exception -> L7
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r8, "getContext(...)");     // Catch: Exception -> L7
        r5.a(r8, this.f13257a, this.f13258b.a());     // Catch: Exception -> L7
        if (r1 == null) goto L23;
        r1.a(this.f13257a, this.f13258b.a(), true);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if (r1 == null) goto L18;
        r1.a(this.f13257a, this.f13258b.a(), e);
    L18:
        if (r1 == null) goto L24;
        r1.a(this.f13257a, this.f13258b.a(), false);
        return;
    L24:
        return;
    L23:
        return;
    L21:
        if (r1.a(this.f13257a, this.f13258b.a()) == true) goto L9;
        r4 = true;
        goto L10
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(this.f13258b.c());
        r2.setUnderlineText(this.f13258b.d());
    }
}
