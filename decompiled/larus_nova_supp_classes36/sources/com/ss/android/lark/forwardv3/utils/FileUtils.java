package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FileUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/utils/FileUtils$ReceiveAuthorizationState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final a Companion = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;
        public static final /* synthetic */ ReceiveAuthorizationState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ReceiveAuthorizationState> getEntries() {
            return b;
        }

        static {
            ReceiveAuthorizationState r0 = new ReceiveAuthorizationState("UNKNOWN", 0);
            UNKNOWN = r0;
            ReceiveAuthorizationState r1 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
            MIDDLE_AUTHORIZATION_STATE = r1;
            ReceiveAuthorizationState r3 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
            FINAL_AUTHORIZATION_STATE_PASS = r3;
            ReceiveAuthorizationState r5 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
            FINAL_AUTHORIZATION_STATE_DENY = r5;
            ReceiveAuthorizationState r7 = new ReceiveAuthorizationState("NORMAL_STATE", 4);
            NORMAL_STATE = r7;
            ReceiveAuthorizationState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) a.clone();
        }

        public static ReceiveAuthorizationState valueOf(String r1) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r1);
        }

        public ReceiveAuthorizationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReceiveAuthorizationState.values().length];
            r0[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static void a(Context r1, FilePermCheckBlockInfo r2) {
        if (r1 == null) goto L17;
        if (r2 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2.popup_title) == true) goto L14;
        if (TextUtils.isEmpty(r2.popup_text) == true) goto L14;
        if (TextUtils.isEmpty(r2.button) == true) goto L14;
        UICallbackExecutor.execute(new c(r1, r2));
        return;
    L14:
        if (TextUtils.isEmpty(r2.toast) == true) goto L18;
        UICallbackExecutor.execute(new d(r1, r2));
        return;
    L18:
        return;
    }
}
