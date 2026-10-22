package com.larus.bmhome.instruction.helper;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/instruction/helper/IConvReplyModeRecordHelper;", "", "updateLatestReplyOption", "", "conversationId", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getLatestReplyOption", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IConvReplyModeRecordHelper {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001d\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/instruction/helper/IConvReplyModeRecordHelper$Companion;", "Lcom/larus/bmhome/instruction/helper/IConvReplyModeRecordHelper;", "<init>", "()V", "getLatestReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "conversationId", "", "updateLatestReplyOption", "", "replyOption", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IConvReplyModeRecordHelper {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IConvReplyModeRecordHelper b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper
        public final void a(String r2, ReplyOption r3) {
            this.b.a(r2, r3);
        }

        @Override // com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper
        public final ReplyOption b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            return this.b.b(r2);
        }

        private Companion() {
            IConvReplyModeRecordHelper r0 = (IConvReplyModeRecordHelper) ServiceManager.get().getService(IConvReplyModeRecordHelper.class);
            if (r0 != null) goto L5;
            r0 = new EmptyConvReplyModeRecordHelper();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void a(String r1, ReplyOption r2);

    ReplyOption b(String r1);
}
