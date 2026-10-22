package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final TagData a(com.bytedance.lark.pb.basic.v1.TagData r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        List r9 = r8.tag_data_items;
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L10;
        com.bytedance.lark.pb.basic.v1.TagData.TagDataItem r2 = (com.bytedance.lark.pb.basic.v1.TagData.TagDataItem) r10.next();
        String r4 = r2.text_val;
        TagTypeEnum.a r5 = TagTypeEnum.Companion;
        int r6 = r2.req_tag_type.getValue();
        r5.getClass();
        TagTypeEnum r7 = TagTypeEnum.a.a(r6);
        TagRelationTypeEnum.a r11 = TagRelationTypeEnum.Companion;
        int r12 = r2.resp_tag_type.getValue();
        r11.getClass();
        r1.add(new TagDataItem(r4, r7, TagRelationTypeEnum.a.a(r12), r2.priority));
        goto L7
    L10:
        return new TagData(r1);
    }
}
