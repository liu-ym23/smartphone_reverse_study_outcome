package com.ss.android.lark.picker.doubao.assembly;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterPlugin;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o5b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@DoubaoLocalChatterPlugin
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/DoubaoLocalChatterProviderImpl;", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;", "chatterService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "currentTimeSeconds", "Lkotlin/Function0;", "", "<init>", "(Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;Lkotlin/jvm/functions/Function0;)V", "getTagStatesByChatterIds", "", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "chatterIds", "", "Companion", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoLocalChatterProviderImpl implements DoubaoLocalChatterProvider {
    private static final Companion Companion = null;
    private static final String ON_LEAVE_TAG_KEY = "GeneralVacation";
    private final h chatterService;
    private final Function0<Long> currentTimeSeconds;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/DoubaoLocalChatterProviderImpl$Companion;", "", "<init>", "()V", "ON_LEAVE_TAG_KEY", "", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DoubaoLocalChatterProviderImpl() {
        h r0 = null;
        this(r0, r0, 3, r0);
    }

    @Override // com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider
    public Map<String, DoubaoLocalChatterTagState> getTagStatesByChatterIds(List<String> r18) {
        Intrinsics.checkNotNullParameter(r18, "chatterIds");
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r18.iterator();
    L3:
        boolean r4 = true;
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (((String) r3).length() > 0) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r2.add(r3);
        goto L3
    L11:
        List r5 = CollectionsKt.distinct(r2);
        if (r5.isEmpty() == true) goto L14;
        long r6 = ((Number) this.currentTimeSeconds.invoke()).longValue();
        Map r7 = this.chatterService.a0(r5);
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
        Iterator r9 = r7.entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L66;
        Map.Entry r10 = (Map.Entry) r9.next();
        Object r11 = r10.getKey();
        Chatter r12 = (Chatter) r10.getValue();
        boolean r13 = r12.isDimission();
        boolean r14 = r12.isFrozen();
        TagData r15 = r12.getTagData();
        TagRelationTypeEnum r16 = null;
        if (r15 == null) goto L36;
        List r17 = r15.getTagDataItems();
        if (r17 == null) goto L36;
        Iterator r19 = r17.iterator();
    L24:
        if (r19.hasNext() == false) goto L31;
        Object r110 = r19.next();
        if (((TagDataItem) r110).getTagType() != TagTypeEnum.RELATION_TAG) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L24;
    L32:
        TagDataItem r112 = (TagDataItem) r110;
        if (r112 == null) goto L36;
        r16 = r112.getRelationTagType();
        goto L36
    L28:
        r111 = false;
        goto L29
    L31:
        r110 = null;
    L36:
        if (r16 != TagRelationTypeEnum.RELATION_TAG_EXTERNAL) goto L38;
        boolean r113 = true;
    L39:
        List r20 = r12.getCustomStatus();
        if (r20 != null) goto L42;
        r20 = CollectionsKt.emptyList();
    L42:
        List r21 = r20;
        if ((r21 instanceof Collection) == true) goto L45;
    L47:
        Iterator r22 = r21.iterator();
    L49:
        if (r22.hasNext() == false) goto L46;
        ChatterCustomStatus r114 = (ChatterCustomStatus) r22.next();
        b r115 = r114.getEffectiveInterval();
        if (r115 != null) goto L54;
    L52:
        boolean r116 = false;
    L63:
        if (r116 == false) goto L49;
        boolean r23 = true;
    L65:
        r8.put(r11, new DoubaoLocalChatterTagState(r13, r14, r23, r113));
        goto L17
    L54:
        if (Intrinsics.areEqual(r114.getIconKey(), ON_LEAVE_TAG_KEY) == false) goto L52;
        long r117 = r115.getStartTime();
        if (r6 <= r115.getEndTime()) goto L58;
    L60:
        boolean r118 = false;
    L61:
        if (r118 == false) goto L52;
        r116 = true;
        goto L63
    L58:
        if (r117 > r6) goto L60;
        r118 = true;
    L46:
        r23 = false;
        goto L65
    L45:
        if (r21.isEmpty() == false) goto L47;
    L38:
        r113 = false;
        goto L39
    L66:
        return r8;
    L14:
        return MapsKt.emptyMap();
    }

    public DoubaoLocalChatterProviderImpl(h r2, Function0<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterService");
        Intrinsics.checkNotNullParameter(r3, "currentTimeSeconds");
        this.chatterService = r2;
        this.currentTimeSeconds = r3;
    }

    public /* synthetic */ DoubaoLocalChatterProviderImpl(h r1, Function0 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L10;
        Object r5 = k.a(LarkContext.getApplication(), h.class);
        if (r5 == null) goto L8;
        r1 = (h) r5;
        goto L10
    L8:
        throw new IllegalStateException("Get ImSdkChatterService failed".toString());
    L10:
        if ((r3 & 2) == 0) goto L12;
        r2 = AnonymousClass2.INSTANCE;
    L12:
        this(r1, r2);
    }
}
