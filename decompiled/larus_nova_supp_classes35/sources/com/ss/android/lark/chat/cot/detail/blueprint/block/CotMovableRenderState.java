package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotMovableRenderState {
    public final AtomicLong a;
    public volatile Pair<String, Float> b;
    public volatile Status c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/block/CotMovableRenderState$Status;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "IDLE", "PENDING", "SUCCESS", "FAILURE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status FAILURE = null;
        public static final Status IDLE = null;
        public static final Status PENDING = null;
        public static final Status SUCCESS = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("IDLE", 0);
            IDLE = r0;
            Status r1 = new Status("PENDING", 1);
            PENDING = r1;
            Status r3 = new Status("SUCCESS", 2);
            SUCCESS = r3;
            Status r5 = new Status("FAILURE", 3);
            FAILURE = r5;
            Status[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Status.values().length];
            r0[Status.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Status.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Status.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Status.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public CotMovableRenderState() {
        this.a = new AtomicLong();
        this.c = Status.IDLE;
    }

    public final boolean a(long r4, boolean r6) {
        if (r4 == this.a.get()) goto L6;
        return false;
    L6:
        if (r6 == false) goto L8;
        Status r5 = Status.SUCCESS;
    L9:
        this.c = r5;
        return true;
    L8:
        r5 = Status.FAILURE;
        goto L9
    }
}
