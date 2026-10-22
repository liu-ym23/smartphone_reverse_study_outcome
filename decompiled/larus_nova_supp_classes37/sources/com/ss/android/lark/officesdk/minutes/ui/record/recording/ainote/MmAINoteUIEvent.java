package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class MmAINoteUIEvent implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class CreateMarkAINote extends MmAINoteUIEvent {
        public final Source a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteUIEvent$CreateMarkAINote$Source;", "", "<init>", "(Ljava/lang/String;I)V", "Panel", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final enum Source extends Enum<Source> {
            public static final Source Panel = null;
            public static final /* synthetic */ Source[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<Source> getEntries() {
                return b;
            }

            static {
                Source r0 = new Source();
                Panel = r0;
                Source[] r1 = {r0};
                a = r1;
                b = EnumEntriesKt.enumEntries(r1);
            }

            public Source() {
                super("Panel", 0);
            }

            public static Source[] values() {
                return (Source[]) a.clone();
            }

            public static Source valueOf(String r1) {
                return (Source) r27.a.a(Source.class, r1);
            }
        }

        public CreateMarkAINote() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof CreateMarkAINote) == true) goto L9;
            return false;
        L9:
            if (this.a == ((CreateMarkAINote) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CreateMarkAINote(source=" + this.a + ')';
        }

        public CreateMarkAINote(int r2) {
            Source r3 = Source.Panel;
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = r3;
        }
    }

    public static final class a extends MmAINoteUIEvent {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends MmAINoteUIEvent {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends MmAINoteUIEvent {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends MmAINoteUIEvent {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchClick(checked=" + this.a + ')';
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public static final class e extends MmAINoteUIEvent {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchEditorFocusChanged(focused=" + this.a + ')';
        }

        public e(boolean r1) {
            this.a = r1;
        }
    }

    public static final class f extends MmAINoteUIEvent {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.a == ((f) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchKeyboardVisibilityChanged(visible=" + this.a + ')';
        }

        public f(boolean r1) {
            this.a = r1;
        }
    }

    public static final class g extends MmAINoteUIEvent {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.a == ((g) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchPanelVisibilityChanged(visible=" + this.a + ')';
        }

        public g(boolean r1) {
            this.a = r1;
        }
    }

    public static final class h extends MmAINoteUIEvent {
        public static final h a = null;

        static {
            a = new h();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof h) == true) goto L9;
            return false;
        L9:
            h r4 = (h) r3;
            return true;
        }

        public final int hashCode() {
            return 1868780381;
        }

        public final String toString() {
            return "SaveSwitchTooltipClose";
        }

        public h() {
        }
    }

    public static final class i extends MmAINoteUIEvent {
        public static final i a = null;

        static {
            a = new i();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof i) == true) goto L9;
            return false;
        L9:
            i r4 = (i) r3;
            return true;
        }

        public final int hashCode() {
            return -1022656626;
        }

        public final String toString() {
            return "SaveSwitchTooltipDismissed";
        }

        public i() {
        }
    }

    public static final class j extends MmAINoteUIEvent {
        public final long a;
        public final long b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof j) == true) goto L8;
            return false;
        L8:
            j r9 = (j) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            int r4 = 1231;
            if (this.c == false) goto L5;
            int r5 = 1231;
        L6:
            int r6 = (r2 + r5) * 31;
            if (this.d == true) goto L11;
            r4 = 1237;
        L11:
            return r6 + r4;
        L5:
            r5 = 1237;
            goto L6
        }

        public final String toString() {
            return "Show(duration=" + this.a + ", meetingStartTime=" + this.b + ", expandImmediately=" + this.c + ", isWavePlaying=" + this.d + ')';
        }

        public j(long r1, long r3, boolean r5, boolean r6) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class k extends MmAINoteUIEvent {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof k) == true) goto L9;
            return false;
        L9:
            if (this.a == ((k) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SubtitleNavigationResult(success=" + this.a + ')';
        }

        public k(boolean r1) {
            this.a = r1;
        }
    }

    public static final class l extends MmAINoteUIEvent {
        public final long a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof l) == true) goto L8;
            return false;
        L8:
            l r9 = (l) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "UpdateDuration(duration=" + this.a + ", meetingStartTime=" + this.b + ')';
        }

        public l(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class m extends MmAINoteUIEvent {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.a == ((m) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "UpdateWaveAnimation(isPlaying=" + this.a + ')';
        }

        public m(boolean r1) {
            this.a = r1;
        }
    }

    public MmAINoteUIEvent() {
    }
}
