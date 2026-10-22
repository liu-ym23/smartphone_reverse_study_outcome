package com.ss.android.lark.compose.chatsetting.report;

import android.content.Context;
import com.lark.kmp.pb.basic.v1.TnsBlockedFeature;
import com.lark.kmp.pb.basic.v1.TnsOpKind;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowReportManager {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[TnsOpKind.values().length];
            r0[TnsOpKind.TNS_OP_BANNED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            a = r0;
            int[] r1 = new int[TnsBlockedFeature.values().length];
            r1[TnsBlockedFeature.BLOCKED_ADD_MEMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[TnsBlockedFeature.BLOCKED_REMOVE_MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[TnsBlockedFeature.BLOCKED_MODIFY_CHAT_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            b = r1;
        }
    }

    static {
    }

    public final CopyOnWriteArrayList<ChatSettingFunction> a() {
        return (CopyOnWriteArrayList) this.a.getValue();
    }

    public FlowReportManager() {
        this.a = LazyKt.lazy(FlowReportManager$disableFunctionList$2.INSTANCE);
    }

    public static void b(Context r7, String r8, CoroutineScope r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "chatId");
        Intrinsics.checkNotNullParameter(r9, "scope");
        BuildersKt.launch$default(r9, Dispatchers.getMain(), null, new FlowReportManager$report$1(r7, r8, null), 2, null);
    }
}
