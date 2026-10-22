package com.ss.android.lark.create.groupchat.impl.service;

import com.bytedance.lark.pb.im.v1.CreateDepartmentChatResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "it", "Lcom/bytedance/lark/pb/im/v1/CreateDepartmentChatResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CreateGroupService$createDepartmentChat$1 extends Lambda implements Function1<CreateDepartmentChatResponse, Chat> {
    final /* synthetic */ hab.b $chatDependency;

    public CreateGroupService$createDepartmentChat$1(hab.b r1) {
        this.$chatDependency = r1;
        super(1);
    }

    public final Chat invoke(CreateDepartmentChatResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Chat) CollectionsKt.getOrNull(CollectionsKt.toList(this.$chatDependency.getChatParser().getChatMap(r2.entity.chats).values()), 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CreateDepartmentChatResponse) r1);
    }
}
