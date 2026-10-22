package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class k {
    public final String a;

    public static final class a extends k {
        public final dq8.a b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((a) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "ButtonRouterClicked(event=" + this.b + ')';
        }

        public a(dq8.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            super("ButtonRouterClicked");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.b(this.b);
        }
    }

    public static final class b extends k {
        public final dq8.b b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((b) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "ButtonRouterShown(event=" + this.b + ')';
        }

        public b(dq8.b r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            super("ButtonRouterShown");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.d(this.b);
        }
    }

    public static final class c extends k {
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "CommandInputHintChanged(widgetId=" + this.b + ", hint=" + this.c + ", from=" + this.d + ')';
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r4) {
            Intrinsics.checkNotNullParameter(r4, "sink");
            r4.m(this.b, this.c, this.d);
        }

        public c(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "widgetId");
            Intrinsics.checkNotNullParameter(r4, "hint");
            Intrinsics.checkNotNullParameter("CommandController#collegeEntranceExam", "from");
            super("CommandInputHintChanged");
            this.b = r3;
            this.c = r4;
            this.d = "CommandController#collegeEntranceExam";
        }
    }

    public static final class d extends k {
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "CommandRestoreDefaultInputHint(widgetId=" + this.b + ", from=" + this.c + ')';
        }

        public d(String r3) {
            Intrinsics.checkNotNullParameter(r3, "widgetId");
            Intrinsics.checkNotNullParameter("CommandController#collegeEntranceExam", "from");
            super("CommandRestoreDefaultInputHint");
            this.b = r3;
            this.c = "CommandController#collegeEntranceExam";
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r3) {
            Intrinsics.checkNotNullParameter(r3, "sink");
            r3.c(this.b, this.c);
        }
    }

    public static final class e extends k {
        public final Long b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((e) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "DefaultSelectedImageStyleIdChanged(styleId=" + this.b + ')';
        }

        public e(Long r2) {
            super("DefaultSelectedImageStyleIdChanged");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.l(this.b);
        }
    }

    public static final class f extends k {
        public final dq8.i b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((f) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "ExecuteCommand(toHostCommand=" + this.b + ')';
        }

        public f(dq8.i r2) {
            Intrinsics.checkNotNullParameter(r2, "toHostCommand");
            super("ExecuteCommand");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.n(this.b);
        }
    }

    public static final class g extends k {
        public final boolean b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.b == ((g) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ImageStyleRadioSelectedChanged(isSelected=" + this.b + ')';
        }

        public g(boolean r2) {
            super("ImageStyleRadioSelectedChanged");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.a(this.b);
        }
    }

    public static final class h extends k {
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.b;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "InputHintChanged(hint=" + this.b + ", from=" + this.c + ')';
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r3) {
            Intrinsics.checkNotNullParameter(r3, "sink");
            r3.onInputHintChanged(this.b, this.c);
        }

        public h(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "from");
            super("InputHintChanged");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class i extends k {
        public final bq8.a b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((i) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            bq8.a r0 = this.b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "InstructionToMusicTemplateSelected(template=" + this.b + ')';
        }

        public i(bq8.a r2) {
            super("InstructionToMusicTemplateSelected");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.onInstructionMusicTemplateSelected(this.b);
        }
    }

    public static final class j extends k {
        public final boolean b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (this.b == ((j) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "MediaSelectorOpenAlbum(isReplace=" + this.b + ')';
        }

        public j(boolean r2) {
            super("MediaSelectorOpenAlbum");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.i(this.b);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.base.k$k, reason: collision with other inner class name */
    public static final class C0016k extends k {
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0016k) == true) goto L8;
            return false;
        L8:
            C0016k r6 = (C0016k) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.b;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MediaSelectorPreview(url=" + this.b + ", localPath=" + this.c + ')';
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r3) {
            Intrinsics.checkNotNullParameter(r3, "sink");
            r3.h(this.b, this.c);
        }

        public C0016k(String r2, String r3) {
            super("MediaSelectorPreview");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class l extends k {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((l) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "MediaSelectorRemove(identifier=" + this.b + ')';
        }

        public final String getIdentifier() {
            return this.b;
        }

        public l(String r2) {
            super("MediaSelectorRemove");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.e(this.b);
        }
    }

    public static final class m extends k {
        public final int b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.b == ((m) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b;
        }

        public final String toString() {
            return "MenuTabSwitched(selectedIndex=" + this.b + ')';
        }

        public m(int r2) {
            super("MenuTabSwitched");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.j(this.b);
        }
    }

    public static final class n extends k {
        public final t1 b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof n) == true) goto L8;
            return false;
        L8:
            n r6 = (n) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ParamFilterConfChanged(paramFilterConf=" + this.b + ", isInitial=" + this.c + ')';
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r3) {
            Intrinsics.checkNotNullParameter(r3, "sink");
            r3.g(this.b, this.c);
        }

        public n(t1 r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "paramFilterConf");
            super("ParamFilterConfChanged");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class o extends k {
        public final List<w> b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof o) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((o) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "RatioOptionListUpdated(optionList=" + this.b + ')';
        }

        public o(List<w> r2) {
            Intrinsics.checkNotNullParameter(r2, "optionList");
            super("RatioOptionListUpdated");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.k(this.b);
        }
    }

    public static final class p extends k {
        public final i0 b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof p) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((p) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "TabSwitched(template=" + this.b + ')';
        }

        public p(i0 r2) {
            Intrinsics.checkNotNullParameter(r2, "template");
            super("TabSwitched");
            this.b = r2;
        }

        @Override // com.larus.bmhome.instruction.core.impl.base.k
        public final void a(dq8.g r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            r2.f(this.b);
        }
    }

    public abstract void a(dq8.g r1);

    public k(String r1) {
        this.a = r1;
    }
}
