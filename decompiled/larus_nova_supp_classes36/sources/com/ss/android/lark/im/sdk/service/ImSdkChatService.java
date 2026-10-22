package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface ImSdkChatService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/im/sdk/service/ImSdkChatService$Source;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT_WINDOW", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Source extends Enum<Source> {
        public static final Source CHAT_WINDOW = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN", 0, 1);
            UNKNOWN = r0;
            Source r1 = new Source("CHAT_WINDOW", 1, 2);
            CHAT_WINDOW = r1;
            Source[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final boolean a;
        public final ProfileSource b;

        public a() {
            this(false, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            ProfileSource r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CreateP2pChatParams(isSecretChat=" + this.a + ", profileSource=" + this.b + ')';
        }

        public a(boolean r1, ProfileSource r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    Chat B2(String r1);

    void C2(List<String> r1, IGetDataCallback<Map<String, Chat>> r2);

    com.ss.android.lark.chat.entity.chat.b I0(String r1);

    Chat P6(String r1, Source r2);

    void X5(String r1, a r2, IGetDataCallback<Chat> r3);

    void Y6(List<String> r1, String r2, IGetDataCallback<Map<String, Boolean>> r3);

    Chat getLocalChat(String r1);

    String getOtherP2PChatterId(Chat r1);

    com.ss.android.lark.chat.entity.chat.a nd(String r1);

    void uc(List r1, ChatApiImpl$selectMessagesFromChat$1 r2);

    Chat we(String r1);

    Chat xc(String r1);
}
