package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowRelationshipBanner extends wya.a<d> {
    public static final /* synthetic */ int g = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/plugin/FlowRelationshipBanner$Type;", "", "<init>", "(Ljava/lang/String;I)V", "STRANGER", "BLOCK", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Type extends Enum<Type> {
        public static final Type BLOCK = null;
        public static final Type STRANGER = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("STRANGER", 0);
            STRANGER = r0;
            Type r1 = new Type("BLOCK", 1);
            BLOCK = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends wya.a.a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c {
        public final Drawable a;
        public final CharSequence b;
        public final CharSequence c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Content(icon=" + this.a + ", title=" + this.b + ", description=" + this.c + ')';
        }

        public c(Drawable r2, CharSequence r3, CharSequence r4) {
            Intrinsics.checkNotNullParameter(r2, "icon");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "description");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d implements wya.c {
        public final Type a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Data(type=" + this.a + ')';
        }

        public final Type getType() {
            return this.a;
        }

        public d(Type r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.STRANGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Type.BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131561145;
    }

    public int getType() {
        return 2048;
    }

    public FlowRelationshipBanner(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        super(r2);
    }

    public final /* bridge */ /* synthetic */ void d(wya.c r1) {
        f((d) r1);
    }

    public final void f(d r6) {
        View r0 = ((wya.a) this).f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        Context r1 = r0.getContext();
        Type r7 = r6.getType();
        int r8 = e.a[r7.ordinal()];
        if (r8 != 1) goto L10;
        c r9 = new c(UIUtils.getDrawable(r1, 2131235472), UIUtils.getString(r1, 2131889995), UIUtils.getString(r1, 2131889991));
    L19:
        ((ImageView) r0.findViewById(2131373032)).setImageDrawable(r9.a);
        ((TextView) r0.findViewById(2131373033)).setText(r9.b);
        ((TextView) r0.findViewById(2131373031)).setText(r9.c);
        return;
    L10:
        if (r8 != 2) goto L17;
        Drawable r2 = UIUtils.getDrawable(r1, 2131235453);
        String r3 = UIUtils.getString(r1, 2131889984);
        if (((itb.a) LarkContext.spiByDwarf(itb.a.class)).i1() == false) goto L14;
        String r4 = UIUtils.getString(r1, 2131889983);
    L15:
        Intrinsics.checkNotNull(r4);
        r9 = new c(r2, r3, r4);
        goto L19
    L14:
        r4 = UIUtils.getString(r1, 2131889985);
        goto L15
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final void c(View r2, wya.c r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r2, "view");
        ((wya.a) this).f = r2;
        r2.findViewById(2131373030).setOnClickListener(new j(this));
        f((d) r3);
    }
}
