package com.obric.assistant.card.layout.viewholder.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.aiagent.assistant.common.ui.icon.TaskResolvedIcon;
import com.obric.aiagent.assistant.common.ui.icon.b;
import com.obric.aiagent.assistant.common.ui.icon.c;
import com.obric.aiagent.assistant.common.ui.icon.d;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemEventTaskBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rca.f;
import rca.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0017H\u0004¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemEventTaskBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "getSemanticIconValue", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "key", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemEventTaskStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemEventTaskBinding> {
    public static final /* synthetic */ int l = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "StyleData(conditionString=" + this.a + ", taskQuery=" + this.b + ", periodString=" + this.c + ", iconKey=" + this.d + ", colorKey=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "conditionString");
            Intrinsics.checkNotNullParameter(r3, "taskQuery");
            Intrinsics.checkNotNullParameter(r4, "periodString");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public abstract a a4(Object r1);

    public AbsCardItemEventTaskStyle(ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        ConstraintLayout r13 = LayoutInflater.from(r12.getContext()).inflate(2131563950, r12, false);
        int r0 = 2131367631;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131367631);
        if (r4 == null) goto L17;
        r0 = 2131367634;
        View r5 = ViewBindings.findChildViewById(r13, 2131367634);
        if (r5 == null) goto L17;
        r0 = 2131382104;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, 2131382104);
        if (r6 == null) goto L17;
        r0 = 2131383528;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131383528);
        if (r7 == null) goto L17;
        ConstraintLayout r8 = r13;
        r0 = 2131384904;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131384904);
        if (r9 == null) goto L17;
        r0 = 2131388220;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r13, 2131388220);
        if (r10 == null) goto L17;
        super(new ObricCardItemEventTaskBinding(r8, r4, r5, r6, r7, r8, r9, r10));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }

    public static String b4(AppEntity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        String r4 = r2.getExtraData();     // Catch: Throwable -> L12
        if (r4 != null) goto L6;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        String r5 = new JSONObject(r4).optString(r3);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        if ((!StringsKt.isBlank(r5)) == true) goto L10;
        r5 = null;
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L19;
        r0 = r6;
    L19:
        return (String) r0;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r10, final T r11, int r12, final boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "messageExtra");
        a r15 = a4(r11);
        ImageView r16 = ((ObricCardItemEventTaskBinding) this.a).h;
        String r17 = r15.d;
        String r0 = r15.e;
        int r1 = d.a;
        Intrinsics.checkNotNullParameter(r16, "imageView");
        Intrinsics.checkNotNullParameter(r16, "imageView");
        Context r2 = r16.getContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        TaskResolvedIcon.Companion.getClass();
        TaskResolvedIcon r3 = TaskResolvedIcon.a.a(r17);
        if (r3 != null) goto L32;
        int r4 = c.a;
        Map<String, List<String>> r5 = b.a;
        String r6 = TaskResolvedIcon.a.b(r17);
        if (r6 == null) goto L9;
        List<String> r7 = b.a.get(r6);
        if (r7 == null) goto L9;
    L11:
        if (r7.isEmpty() == false) goto L13;
        String r18 = TaskResolvedIcon.GENERAL_3.getKey();
    L28:
        TaskResolvedIcon r19 = TaskResolvedIcon.a.a(r18);
        if (r19 != null) goto L31;
        r19 = TaskResolvedIcon.GENERAL_3;
    L31:
        r3 = r19;
        goto L32
    L13:
        String r8 = TaskResolvedIcon.a.b(null);
        if (r8 != null) goto L16;
    L18:
        if (r17 != null) goto L20;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        int r110 = r17.hashCode();
        int r9 = r7.size();
        int r20 = r110 % r9;
        if (r20 != 0) goto L24;
        r20 = 0;
    L27:
        r18 = (String) ListProtector.get(r7, r20);
        goto L28
    L24:
        if ((((r110 ^ r9) >> 31) | 1) > 0) goto L27;
        r20 = r20 + r9;
        goto L27
    L16:
        if (r7.contains(r8) == false) goto L18;
        r18 = r8;
    L9:
        r7 = CollectionsKt.emptyList();
    L32:
        int r111 = r3.getDrawableRes();
        Map<String, Integer> r21 = com.obric.aiagent.assistant.common.ui.icon.a.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        String r22 = TaskResolvedIcon.a.b(r0);
        if (r22 == null) goto L35;
        Integer r23 = com.obric.aiagent.assistant.common.ui.icon.a.a.get(r22);
    L36:
        if (r23 != null) goto L40;
        r23 = com.obric.aiagent.assistant.common.ui.icon.a.a.get("gray");
        if (r23 != null) goto L40;
        int r24 = 0;
    L42:
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2.getResources().getConfiguration().uiMode & 48) != 32) goto L45;
        boolean r25 = true;
    L46:
        int r26 = l9a.a.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Drawable r112 = r2.getDrawable(r111);
        if (r112 != null) goto L49;
        l9a.a.C0098a r27 = null;
    L50:
        r16.setImageDrawable(r27);
        r16.setImageTintList(null);
        r16.clearColorFilter();
        ((ObricCardItemEventTaskBinding) this.a).b.setText(r15.a);
        ((ObricCardItemEventTaskBinding) this.a).e.setText(r15.b);
        ((ObricCardItemEventTaskBinding) this.a).d.setText(r15.c);
        View r113 = ((ObricCardItemEventTaskBinding) this.a).c;
        if ((!StringsKt.isBlank(r15.a)) == true) goto L53;
    L55:
        int r114 = 8;
    L56:
        r113.setVisibility(r114);
        Y3(!r13, null, false);
        ((ObricCardItemEventTaskBinding) this.a).f.setOnClickListener(new f(r13, this, r11));
        ((ObricCardItemEventTaskBinding) this.a).g.setOnClickListener(new g(r13, r11));
        return;
    L53:
        if ((!StringsKt.isBlank(r15.c)) == false) goto L55;
        r114 = 0;
        goto L56
    L49:
        Intrinsics.checkNotNullParameter(r112, "drawable");
        r27 = new l9a.a.C0098a(r112.mutate(), r24, r25, false);
        goto L50
    L45:
        r25 = false;
    L40:
        r24 = r23.intValue();
        goto L42
    L35:
        r23 = null;
        goto L36
    }
}
