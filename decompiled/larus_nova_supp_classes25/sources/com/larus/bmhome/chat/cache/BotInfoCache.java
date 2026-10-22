package com.larus.bmhome.chat.cache;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.platform.service.AccountService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002J\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/cache/BotInfoCache;", "Ljava/util/HashMap;", "", "Lcom/larus/im/bean/bot/BotModel;", "Lkotlin/collections/HashMap;", "<init>", "()V", "getBotId", "conversationId", "getModelType", "", "isTypeWriter", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getTypeWriter", "", "isOwnBot", "getBotType", "(Ljava/lang/String;)Ljava/lang/Integer;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotInfoCache extends HashMap<String, BotModel> {
    public static final BotInfoCache INSTANCE = null;

    static {
        INSTANCE = new BotInfoCache();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, BotModel>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, BotModel>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<BotModel> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<BotModel> values() {
        return getValues();
    }

    private BotInfoCache() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if (r2 != null) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == true) goto L9;
        return false;
    L9:
        return containsValue((BotModel) r2);
    L4:
        r0 = r2 instanceof BotModel;
        goto L5
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ BotModel get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    public final String getBotId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        BotModel r3 = (BotModel) get(r2);
        if (r3 == null) goto L5;
        String r4 = r3.getBotId();
    L6:
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public final Integer getBotType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        BotModel r3 = (BotModel) get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getBotType();
    }

    public final long getModelType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        BotModel r4 = (BotModel) get(r3);
        if (r4 == null) goto L7;
        ModelItem r5 = r4.getModel();
        if (r5 == null) goto L7;
        return r5.getModelType();
    L7:
        return -1;
    }

    public final int getTypeWriter(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return !Intrinsics.areEqual(isTypeWriter(r2), Boolean.FALSE) ? 1 : 0;
    }

    public final boolean isOwnBot(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        BotModel r3 = (BotModel) get(r2);
        if (r3 == null) goto L7;
        BotCreatorInfo r4 = r3.getBotCreatorInfo();
        if (r4 == null) goto L7;
        String r5 = r4.getId();
    L9:
        return Intrinsics.areEqual(r5, AccountService.a.getUserId());
    L7:
        r5 = null;
        goto L9
    }

    public final Boolean isTypeWriter(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        BotModel r3 = (BotModel) get(r2);
        if (r3 == null) goto L7;
        ModelItem r4 = r3.getModel();
        if (r4 == null) goto L7;
        return r4.getTypeWriter();
    L7:
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ BotModel remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(BotModel r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ BotModel get(String r1) {
        return (BotModel) super.get(r1);
    }

    public /* bridge */ BotModel remove(String r1) {
        return (BotModel) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (BotModel) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        if ((r3 instanceof String) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        return false;
    L11:
        return remove((String) r3, (BotModel) r4);
    L7:
        r0 = r4 instanceof BotModel;
        goto L8
    }

    public final /* bridge */ BotModel getOrDefault(Object r2, BotModel r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    public /* bridge */ boolean remove(String r1, BotModel r2) {
        return super.remove(r1, r2);
    }

    public /* bridge */ BotModel getOrDefault(String r1, BotModel r2) {
        return (BotModel) super.getOrDefault(r1, r2);
    }
}
