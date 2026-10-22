package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u00020\r*\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagMapper;", "", "<init>", "()V", "map", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "localState", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "currentTimeSeconds", "", "shouldShowExternalTag", "", "allowUnknownExternal", "hasActiveOnLeaveStatus", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "ON_LEAVE_TAG_KEY", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerTagMapper {
    public static final DoubaoPickerTagMapper INSTANCE = null;
    private static final String ON_LEAVE_TAG_KEY = "GeneralVacation";

    static {
        INSTANCE = new DoubaoPickerTagMapper();
    }

    private DoubaoPickerTagMapper() {
    }

    private final boolean hasActiveOnLeaveStatus(SearchChatterInfo r7, long r8) {
        List r9 = r7.getStatusList();
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        List r10 = r9;
        if ((r10 instanceof Collection) == true) goto L8;
    L10:
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L35;
        Chatter.ChatterCustomStatus r0 = (Chatter.ChatterCustomStatus) r11.next();
        StatusEffectiveInterval r2 = r0.effective_interval;
        if (r2 != null) goto L17;
    L15:
        boolean r1 = false;
    L26:
        if (r1 == false) goto L12;
        return true;
    L17:
        if (Intrinsics.areEqual(r0.icon_key, ON_LEAVE_TAG_KEY) == false) goto L15;
        Long r3 = r2.start_time;
        if (r8 <= r2.end_time.longValue()) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L15;
        r1 = true;
        goto L26
    L21:
        if (r3.longValue() > r8) goto L23;
        r4 = true;
        goto L24
    L35:
        return false;
    L8:
        if (r10.isEmpty() == false) goto L10;
        return false;
    }

    private final boolean shouldShowExternalTag(SearchBaseInfo r8, boolean r9) {
        TagData r10 = r8.getTagData();
        Object r0 = null;
        if (r10 == null) goto L5;
        List r11 = r10.getTagDataItems();
    L6:
        if (r11 != null) goto L8;
        r11 = CollectionsKt.emptyList();
    L8:
        List r12 = r11;
        Iterator r1 = r12.iterator();
    L10:
        if (r1.hasNext() == false) goto L17;
        Object r2 = r1.next();
        if (((TagDataItem) r2).getTagType() != TagTypeEnum.RELATION_TAG) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L10;
        r0 = r2;
        goto L17
    L14:
        r5 = false;
    L17:
        TagDataItem r3 = (TagDataItem) r0;
        if (r3 != null) goto L20;
        if (r9 == true) goto L26;
    L43:
        return false;
    L26:
        if ((r12 instanceof Collection) == true) goto L28;
    L30:
        Iterator r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L29;
        TagDataItem r14 = (TagDataItem) r13.next();
        if (r14.getTagType() == TagTypeEnum.UNKNOWN_TAG_TYPE) goto L36;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == false) goto L32;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L43;
        return true;
    L36:
        if (r14.getRelationTagType() != TagRelationTypeEnum.RELATION_TAG_EXTERNAL) goto L38;
        r15 = true;
    L29:
        r16 = false;
        goto L41
    L28:
        if (r12.isEmpty() == false) goto L30;
    L20:
        if (r3.getRelationTagType() == TagRelationTypeEnum.RELATION_TAG_EXTERNAL) goto L55;
        return false;
    L55:
        return true;
    L5:
        r11 = null;
        goto L6
    }

    public final DoubaoPickerTagState map(SearchBaseInfo r26, DoubaoLocalChatterTagState r27, long r28) {
        Intrinsics.checkNotNullParameter(r26, "info");
        if ((r26 instanceof SearchChatterInfo) == false) goto L46;
        SearchChatterInfo r5 = (SearchChatterInfo) r26;
        if (r5.isResigned() == true) goto L14;
        if (r27 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L14;
        boolean r7 = false;
    L15:
        if (r27 != null) goto L17;
    L19:
        boolean r8 = false;
    L21:
        if (hasActiveOnLeaveStatus(r5, r28) == true) goto L30;
        if (r27 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L30;
        boolean r10 = false;
    L32:
        if (shouldShowExternalTag(r26, true) == false) goto L34;
    L43:
        boolean r11 = true;
    L53:
        return new DoubaoPickerTagState(r7, r8, r10, r11, false, false, r5.isAgent(), 48, null);
    L34:
        if (r5.getTagData() != null) goto L42;
        if (r27 != null) goto L37;
    L39:
        boolean r1 = false;
    L40:
        if (r1 == false) goto L42;
    L37:
        if (r27.isExternal() != true) goto L39;
        r1 = true;
    L42:
        r11 = false;
        goto L53
    L24:
        if (r27.isOnLeave() != true) goto L26;
        r9 = true;
    L30:
        r10 = true;
        goto L32
    L17:
        if (r27.isFrozen() != true) goto L19;
        r8 = true;
        goto L21
    L8:
        if (r27.isResigned() != true) goto L10;
        r6 = true;
    L14:
        r7 = true;
        goto L15
    L46:
        if ((r26 instanceof SearchChatInfo) == false) goto L52;
        SearchChatInfo r12 = (SearchChatInfo) r26;
        List r13 = r12.getTags();
        if (r13 != null) goto L54;
        r13 = CollectionsKt.emptyList();
    L54:
        return new DoubaoPickerTagState(false, r13.contains(Tag.FROZEN), false, shouldShowExternalTag$default(this, r26, false, 1, null), r12.isPublic(), r12.isDepartment(), false, 69, null);
    L52:
        return new DoubaoPickerTagState(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ boolean shouldShowExternalTag$default(DoubaoPickerTagMapper r0, SearchBaseInfo r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        return r0.shouldShowExternalTag(r1, r2);
    }

    public static /* synthetic */ DoubaoPickerTagState map$default(DoubaoPickerTagMapper r0, SearchBaseInfo r1, DoubaoLocalChatterTagState r2, long r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = System.currentTimeMillis() / 1000;
    L9:
        return r0.map(r1, r2, r3);
    }
}
