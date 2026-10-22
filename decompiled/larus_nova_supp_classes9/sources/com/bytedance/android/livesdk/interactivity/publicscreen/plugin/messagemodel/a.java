package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.api.publicscreen.j<b, PublicScreenAIAutoReplyViewHolder> {
    public final PublicScreenConfig$ViewBinderType a;

    public a() {
        this.a = PublicScreenConfig$ViewBinderType.AI_AUTO_REPLY;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PublicScreenConfig$ViewBinderType a() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PSMessageViewHolder c(LayoutInflater r2, ViewGroup r3, g52.c r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutInflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = r2.inflate(2131566224, r3, false);
        if (r5.getLayoutParams() != null) goto L6;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new PublicScreenAIAutoReplyViewHolder(r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void b(PSMessageViewHolder r7, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r8, int r9, g52.e r10) {
        PublicScreenAIAutoReplyViewHolder r11 = (PublicScreenAIAutoReplyViewHolder) r7;
        b r13 = (b) r8;
        Intrinsics.checkNotNullParameter(r11, "viewHolder");
        Intrinsics.checkNotNullParameter(r13, "item");
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "model");
        r11.l.invoke(r13);
        g52.a r0 = r11.e;
        if (r0 == null) goto L5;
        r0.setDispatchCallback(r11);
    L5:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r1 = m.a(null);
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r1.getValue();
        if (r2 == null) goto L10;
        e52.a r3 = r2.getTextConfig();
    L12:
        if (r3 == null) goto L14;
        r13.k().a.b = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.c(r3, r13);
        r11.W3(r3, r13, false);
    L14:
        r11.f.setAlwaysInvalidate(r13.k().c);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r4 = r11.j;
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r5 = r4.b(r13, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new j(r11));
    L18:
        t.a r6 = t.a;
        NoMoreSpaceTextView r14 = r11.f;
        if (r5 == null) goto L23;
        CharSequence r15 = r5.a;
        if (r15 == null) goto L23;
    L24:
        t.b(r14, r15);
        NoMoreSpaceTextView r16 = r11.f;
        PublicScreenAccessibilityUtil r17 = PublicScreenAccessibilityUtil.a;
        CharSequence r18 = r16.getText();
        if ((r18 instanceof Spanned) == true) goto L27;
        r18 = null;
    L27:
        r17.getClass();
        PublicScreenAccessibilityUtil.a((Spanned) r18, r16, null);
        NoMoreSpaceTextView r19 = r11.f;
        if (r10 == null) goto L30;
        int r20 = g52.e.j;
        r10.a(r19, true);
    L30:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r21 = r11.j;
        if (r21 == null) goto L33;
        r21.a(r13);
    L33:
        Intrinsics.checkNotNullParameter(r13, "model");
        float r23 = UtilityKotlinExtentionsKt.h(14);
        com.bytedance.android.live.base.model.message.j r24 = r13.l;
        if (r24 == null) goto L41;
        String r25 = r24.getReplyContent();
        if (r25 == null) goto L41;
        UtilityKotlinExtentionsKt.w(r11.d);
        if (r10 == null) goto L40;
        r23 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r10.a, r10.i);
        r11.b.setTextSize(0, r23);
    L40:
        SpannableString r110 = new SpannableString(r25);
        ab2.a.e(r110, (int) r23);
        r11.b.setText(r110);
        return;
    L41:
        UtilityKotlinExtentionsKt.t(r11.d);
        return;
    L23:
        r15 = BuildConfig.FLAVOR;
        goto L24
    L17:
        r5 = null;
    L10:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3, int r4, g52.e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.j.a.a(this, r2, r3, r4, r5);
    }
}
