package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ NestedFileContent a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Integer c;

    public /* synthetic */ f(NestedFileContent r1, Map r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r92) {
        NestedFileContent r1 = this.a;
        Map r2 = this.b;
        Integer r3 = this.c;
        Message r4 = (Message) r92;
        Intrinsics.checkNotNullParameter(r4, "msg");
        List r5 = r4.getContentBlock();
        if (r5 == null) goto L7;
        List r6 = CollectionsKt.toMutableList(com.larus.utils.h.b(r5, new j()));
        if (r6 == null) goto L7;
    L8:
        List r7 = r1.getEntities();
        if (r7 == null) goto L16;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L17;
        AttachmentItem r10 = ic8.h.a((UplinkFileEntity) r9.next());
        if (r10 == null) goto L12;
        r8.add(r10);
    L17:
        r6.add(new Block(BlockType.BLOCK_TYPE_ATTACHMENT.getValue(), null, null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new AttachmentBlock(r8), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -134217729, -1, 31, null), false, null, null, null, 246, null));
        LinkedHashMap r11 = new LinkedHashMap();
        Object r12 = r4.getBusinessExt();
        if (r12 != null) goto L20;
        r12 = new LinkedHashMap();
    L20:
        r11.putAll(r12);
        r11.putAll(r2);
        ChatSendUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "content");
        LinkedHashMap r13 = new LinkedHashMap();
        String r14 = com.larus.bmhome.chat.sendimage.e.d(r1);
        if (r14 == null) goto L23;
        String r15 = (String) r13.put("nested_file_local_path_list", r14);
    L23:
        r11.putAll(r13);
        LinkedHashMap r16 = new LinkedHashMap();
        UpdateMessageLocalOption r17 = UpdateMessageLocalOption.REPLACE_BIZ_EXT;
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        kuc.a.f(r18);
        v2 r19 = v2.a;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r20 = zd9.i.c(r11, kuc.a.c(r19, r19));
        String r21 = "";
        if (r20 != null) goto L26;
        r20 = "";
    L26:
        r16.put(r17, r20);
        UpdateMessageLocalOption r22 = UpdateMessageLocalOption.CONTENT;
        String r23 = zd9.i.c(r6, kuc.a.b(Block.Companion.serializer()));
        if (r23 == null) goto L30;
        r21 = r23;
    L30:
        r16.put(r22, r21);
        if (r3 == null) goto L33;
        int r24 = r3.intValue();
        r16.put(UpdateMessageLocalOption.LOCAL_STATUS, String.valueOf(r24));
    L33:
        return r16;
    L16:
        r8 = null;
    L7:
        r6 = new ArrayList();
        goto L8
    }
}
