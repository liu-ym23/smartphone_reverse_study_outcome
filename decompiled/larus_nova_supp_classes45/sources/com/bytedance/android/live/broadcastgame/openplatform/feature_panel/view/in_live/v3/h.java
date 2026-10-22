package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public h(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
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
    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L40;
        r6.booleanValue();
        LiveOpenFeatureChooseListFragmentV3 r7 = this.a;
        int r0 = LiveOpenFeatureChooseListFragmentV3.F;
        if (r7.isAdded() == false) goto L41;
        RecyclerView r1 = r7.q;
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.v(r1, false);
    L9:
        LivePagerSlidingTabStrip r2 = r7.p;
        if (r2 == null) goto L12;
        UtilityKotlinExtentionsKt.v(r2, false);
    L12:
        ViewPager r3 = r7.r;
        if (r3 == null) goto L15;
        UtilityKotlinExtentionsKt.v(r3, false);
    L15:
        r7.Z90();
        OpenFeatureTabPageAdapterV3 r4 = r7.e;
        if (r4 == null) goto L18;
        r4.g(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L18:
        r7.ca0(r7.s, 100, 0);
        LinearLayout r8 = r7.o;
        if (r8 == null) goto L21;
        UtilityKotlinExtentionsKt.v(r8, true);
    L21:
        HSImageView r9 = r7.s;
        if (r9 == null) goto L24;
        r9.setImageResource(2131250537);
    L24:
        SimpleDraweeView r11 = r7.s;
        if (r11 == null) goto L27;
        UtilityKotlinExtentionsKt.v(r11, true);
    L27:
        TextView r12 = r7.x;
        if (r12 == null) goto L30;
        UtilityKotlinExtentionsKt.v(r12, true);
    L30:
        TextView r13 = r7.x;
        if (r13 == null) goto L33;
        r13.setText(s1.B(2131921028));
    L33:
        TextView r14 = r7.v;
        if (r14 == null) goto L36;
        UtilityKotlinExtentionsKt.v(r14, false);
    L36:
        TextView r15 = r7.w;
        if (r15 == null) goto L42;
        UtilityKotlinExtentionsKt.v(r15, false);
        return;
    L42:
        return;
    L41:
        return;
    }
}
