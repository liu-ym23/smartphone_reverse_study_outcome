package com.ss.android.lark.chatwindow.view.photopreview;

import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.chatwindow.chat.model.viewdata.b;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnLoadMoreListener;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LoadMoreListenerImpl implements OnLoadMoreListener {
    private String mAnonymousId;
    private final String mChatId;
    private boolean mIsReverser;

    public LoadMoreListenerImpl(String r2) {
        this(r2, BuildConfig.FLAVOR);
    }

    public List<ImageSet> onLoadLeft(String r2) {
        if (this.mIsReverser == false) goto L7;
        return a(r2, ImageHistoryResponse.Direction.AFTER);
    L7:
        return a(r2, ImageHistoryResponse.Direction.BEFORE);
    }

    public List<ImageSet> onLoadRight(String r2) {
        if (this.mIsReverser == false) goto L7;
        return a(r2, ImageHistoryResponse.Direction.BEFORE);
    L7:
        return a(r2, ImageHistoryResponse.Direction.AFTER);
    }

    public void setIsReverser(boolean r1) {
        this.mIsReverser = r1;
    }

    public LoadMoreListenerImpl(String r2, String r3) {
        this.mIsReverser = false;
        this.mChatId = r2;
        this.mAnonymousId = r3;
    }

    public final List<ImageSet> a(String r8, ImageHistoryResponse.Direction r9) {
        IChatService r0 = ChatAppContainerV1.a.j0();
        p r1 = ImSdkService.f();
        ImageHistoryResponse r10 = r0.ze(this.mChatId, r8, r9);
        if (r10 == null) goto L5;
        List r11 = r10.getImageSetList();
        Chat r12 = r0.getChatById(this.mChatId);
        ArrayList r2 = new ArrayList(r11.size());
        Iterator r3 = r11.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r2.add(((ImageSet) r3.next()).getMessageIdentity().getMessageId());
        goto L8
    L10:
        ArrayList r4 = new ArrayList(r1.W5(r2).values());
        new b(new ImFileAuthorityChecker("LoadMoreListenerImpl"), FeatureGatingModule.getFeatureGatingService(), ChatAppContainerV1.a.M()).a(r12, r4);
        HashMap r13 = new HashMap(r4.size());
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        MessageInfo r6 = (MessageInfo) r5.next();
        r13.put(r6.getId(), r6.getMessage());
        goto L12
    L14:
        LinkedList r7 = new LinkedList();
        Iterator r14 = r11.iterator();
    L16:
        if (r14.hasNext() == false) goto L28;
        ImageSet r15 = (ImageSet) r14.next();
        String r16 = r15.getMessageIdentity().getMessageId();
        if (r13.containsKey(r16) == false) goto L20;
        Message r17 = (Message) r13.get(r16);
    L21:
        if (r17 == null) goto L23;
        ValidateIMFileResult r18 = r17.getValidateIMFileResult();
    L24:
        if (r18 != null) goto L26;
        IMFileResult r19 = null;
    L27:
        MessagePermissionUtil.ReceiveAuthorizationState r20 = MessagePermissionUtil.h(r19);
        r15.setHasPreviewPermission(MessagePermissionUtil.d(r17, this.mAnonymousId, null));
        r15.setReceiveAuthorizationStateValue(r20.getValue());
        r15.setValidateIMFileResult(r18);
        r7.addFirst(r15);
        goto L16
    L26:
        r19 = r18.getResultType();
        goto L27
    L23:
        r18 = null;
        goto L24
    L20:
        r17 = null;
        goto L21
    L28:
        return r7;
    L5:
        return new ArrayList();
    }
}
