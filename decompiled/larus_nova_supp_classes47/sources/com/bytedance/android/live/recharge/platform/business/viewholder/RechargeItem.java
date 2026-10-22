package com.bytedance.android.live.recharge.platform.business.viewholder;

import com.bytedance.android.live.recharge.deal.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class RechargeItem {

    public static final class CustomItem extends RechargeItem {
        public long a;
        public long b;
        public String c;
        public Mode d;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem$CustomItem$Mode;", "", "INPUT", "DIAMOND", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum Mode extends Enum<Mode> {
            public static final Mode DIAMOND = null;
            public static final Mode INPUT = null;
            public static final /* synthetic */ Mode[] a = null;

            static {
                Mode r1 = new Mode("INPUT", 0);
                INPUT = r1;
                Mode r2 = new Mode("DIAMOND", 1);
                DIAMOND = r2;
                a = new Mode[]{r1, r2};
            }

            public static Mode valueOf(String r1) {
                return (Mode) r27.a.a(Mode.class, r1);
            }

            public static Mode[] values() {
                return (Mode[]) a.clone();
            }

            public Mode(String r1, int r2) {
                super(r1, r2);
            }
        }

        public CustomItem() {
            this(0);
        }

        public CustomItem(int r5) {
            Mode r6 = Mode.INPUT;
            Intrinsics.checkNotNullParameter("", "description");
            Intrinsics.checkNotNullParameter(r6, "mode");
            this.a = 0;
            this.b = 100;
            this.c = "";
            this.d = r6;
        }
    }

    public static final class a extends RechargeItem {
        public final f a;

        public a(f r2) {
            Intrinsics.checkNotNullParameter(r2, "deal");
            this.a = r2;
        }
    }

    public RechargeItem() {
    }
}
