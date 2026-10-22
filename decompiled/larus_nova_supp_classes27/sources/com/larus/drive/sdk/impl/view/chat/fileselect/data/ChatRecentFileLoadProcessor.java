package com.larus.drive.sdk.impl.view.chat.fileselect.data;

import com.larus.im.bean.message.MessageQueryRequest;
import com.larus.im.d;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import k89.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ChatRecentFileLoadProcessor {
    public final String a;
    public final LoadMode b;
    public final String c;
    public final long d;
    public final long e;
    public final boolean f;
    public final HashSet<String> g;
    public final Lazy h;
    public String i;
    public String j;
    public boolean k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/data/ChatRecentFileLoadProcessor$LoadMode;", "", "<init>", "(Ljava/lang/String;I)V", "CONVERSATION", "USER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadMode extends Enum<LoadMode> {
        public static final LoadMode CONVERSATION = null;
        public static final LoadMode USER = null;
        public static final /* synthetic */ LoadMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadMode> getEntries() {
            return b;
        }

        static {
            LoadMode r0 = new LoadMode("CONVERSATION", 0);
            CONVERSATION = r0;
            LoadMode r1 = new LoadMode("USER", 1);
            USER = r1;
            LoadMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static LoadMode[] values() {
            return (LoadMode[]) a.clone();
        }

        public static LoadMode valueOf(String r1) {
            return (LoadMode) r27.a.a(LoadMode.class, r1);
        }

        public LoadMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LoadMode.values().length];
            r0[LoadMode.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LoadMode.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public ChatRecentFileLoadProcessor(String r3, long r4) {
        LoadMode r0 = LoadMode.USER;
        Intrinsics.checkNotNullParameter(r0, "loadMode");
        this.a = r3;
        this.b = r0;
        this.c = AccountService.a.getUserId();
        this.d = r4;
        this.e = r4 - TimeUnit.DAYS.toMillis(365);
        LarkSocialExp.a.getClass();
        this.f = LarkSocialExp.f();
        this.g = new HashSet();
        this.h = LazyKt.lazy(new k89.b());
    }

    public static Object a(ChatRecentFileLoadProcessor r32, Continuation r33) {
        SafeContinuation r1 = new SafeContinuation(IntrinsicsKt.intercepted(r33));
        LoadMode r2 = r32.b;
        int[] r3 = b.a;
        int r4 = r3[r2.ordinal()];
        if (r4 == 1) goto L8;
        if (r4 != 2) goto L7;
        long r6 = 1;
    L9:
        long r9 = r6;
        int r5 = r3[r32.b.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        String r7 = r32.c;
    L16:
        String r11 = r7;
        long r14 = r32.d;
        long r8 = r32.e;
        String r10 = r32.i;
        boolean r12 = r32.f;
        long r13 = 0;
        if (r12 == false) goto L19;
        long r20 = 0;
    L20:
        if (r12 == false) goto L22;
        r13 = 20;
    L22:
        long r27 = r13;
        String r15 = r32.j;
        if (r12 == false) goto L25;
        String r210 = r15;
    L26:
        ArrayList r16 = new ArrayList();
        r16.add(30100L);
        d.e().u(new MessageQueryRequest(r9, r11, 1, r14, r8, r16, r10, r20, 2, true, null, true, r27, r210, 1024, null), new g(r32, r1));
        Object r0 = r1.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r33);
    L29:
        return r0;
    L25:
        r210 = null;
        goto L26
    L19:
        r20 = 20;
        goto L20
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r7 = r32.a;
        goto L16
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r6 = 3;
        goto L9
    }
}
