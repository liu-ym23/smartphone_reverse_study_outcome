package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.space.doc.v1.RemoveDocRequest;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocMeReadRequest;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocMessageBadgeRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BadgeAgentImpl implements com.bytedance.ee.bear.contract.g.a {
    public BadgeAgentImpl() {
    }

    public final void remove(String r4) {
        IGetDataCallback<Boolean> r0 = new AnonymousClass3(this);
        tt5.a.h("BadgeAgentImpl", "remove doc: ");
        RemoveDocRequest.Builder r5 = new RemoveDocRequest.Builder().token(r4);
        SdkSender.asynSendRequestNonWrap(Command.REMOVE_DOC, r5, r0, new k());
    }

    public final void a(String r3, int r4, final List<String> r5) {
        DocType r0 = DocType.UNKNOWN_DOC_TYPE;
        if (r4 != sbb.e.g.b) goto L6;
        r0 = DocType.DOC;
    L26:
        IGetDataCallback<Boolean> r6 = new AnonymousClass1(this, r5);
        UpdateDocMeReadRequest.Builder r7 = new UpdateDocMeReadRequest.Builder().doc_type(Doc.Type.fromValue(r0.getNumber())).message_ids(r5).token(r3);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_ME_READ, r7, r6, new j());
        return;
    L6:
        if (r4 != sbb.e.h.b) goto L9;
        r0 = DocType.SHEET;
        goto L26
    L9:
        if (r4 != sbb.e.i.b) goto L12;
        r0 = DocType.BITABLE;
        goto L26
    L12:
        if (r4 != sbb.e.l.b) goto L15;
        r0 = DocType.FILE;
        goto L26
    L15:
        if (r4 != sbb.e.k.b) goto L18;
        r0 = DocType.MINDNOTE;
        goto L26
    L18:
        if (r4 != sbb.e.m.b) goto L21;
        r0 = DocType.SLIDES;
        goto L26
    L21:
        if (r4 != sbb.e.o.b) goto L24;
        r0 = DocType.DOCX;
        goto L26
    L24:
        if (r4 != sbb.e.y.b) goto L26;
        r0 = DocType.DOCX_SYNCED_BLOCK;
        goto L26
    }

    public final void b(String r8, final long r9, final long r11) {
        IGetDataCallback<Boolean> r6 = new AnonymousClass5(this, r9, r11);
        tt5.a.h("BadgeAgentImpl", "update badge:" + r9 + ", version=" + r11);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_MESSAGE_BADGE, new UpdateDocMessageBadgeRequest.Builder().token(r8).new_message_count(Integer.valueOf((int) r9)).version(Integer.valueOf((int) r11)), r6, new l());
    }
}
