package com.obric.memorydata.realtimecontext;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.utils.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ0\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J0\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J0\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/realtimecontext/AppEntityProcessor;", "", "<init>", "()V", "extraDataIfNeed", "Lkotlin/Pair;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "entities", "componentName", "Landroid/content/ComponentName;", "extraDataFromContactsList", "", "extraDataFromContactsDetail", "extraDataFromMmsDetail", "extraTelephoneFromContact", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "contactEntity", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12470a = null;

    static {
        f12470a = new i();
    }

    private i() {
    }

    private final List<MetaTelephone> a(ContactEntity r6) {
        List<MetaTelephone> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<MetaTelephone> r7 = r6.getTelephones();
        if (r7 == null) goto L8;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        MetaTelephone r0 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r8.next(), MetaTelephone.class, "com.obric.memorydata.plugin");
        r5.add(new MetaTelephone(t.f13260a.a(r0.getTelephone()), null, 2, null));
    L8:
        return r5;
    }

    private final Pair<List<AppEntity>, List<MetaValue>> a(List<? extends AppEntity> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Pair<List<AppEntity>, List<MetaValue>> r6 = new Pair((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L16;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L16;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r7.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, CallHistoryEntity.class) == false) goto L6;
        List<ContactEntity> r2 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r1, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getContacts();
        if (r2 != null) goto L11;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r1, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTelephones(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r3.hasNext() == false) goto L6;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        goto L14
    L11:
        ((List) ZeusTransformUtils.preCheckCast(r6.getFirst(), List.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    L16:
        return r6;
    }

    private final Pair<List<AppEntity>, List<MetaValue>> b(List<? extends AppEntity> r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Pair<List<AppEntity>, List<MetaValue>> r2 = new Pair((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        LinkedHashSet r4 = new LinkedHashSet();
        if (r0 == null) goto L24;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L24;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r1.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, CallHistoryEntity.class) == false) goto L23;
        List<ContactEntity> r6 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r5, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getContacts();
        if (r6 == null) goto L15;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L23;
        ContactEntity r8 = (ContactEntity) ZeusTransformUtils.preCheckCast(r7.next(), ContactEntity.class, "com.obric.memorydata.plugin");
        r3.put(r8.getId(), r8);
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(f12470a.a(r8), Collection.class, "com.obric.memorydata.plugin"));
        goto L13
    L15:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r5, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTelephones(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        MetaTelephone r11 = new MetaTelephone(t.f13260a.a(r10), null, 2, null);
        if (r4.add(r11) == false) goto L22;
        String r12 = RealTimeContextService.VIRTUAL_CONTACT_ID_PREFIX + r10;
        r3.put(r12, new ContactEntity(r12, 0, 0, "", CollectionsKt.listOf(r11)));
    L22:
        r1 = r1;
    L23:
        r1 = r1;
    L24:
        ((List) ZeusTransformUtils.preCheckCast(r2.getFirst(), List.class, "com.obric.memorydata.plugin")).addAll(r3.values());
        return r2;
    }

    private final Pair<List<AppEntity>, List<MetaValue>> c(List<? extends AppEntity> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Pair<List<AppEntity>, List<MetaValue>> r6 = new Pair((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L10;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r7.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ContactEntity.class) == false) goto L6;
        ((CharSequence) ZeusTransformUtils.preCheckCast(((ContactEntity) ZeusTransformUtils.preCheckCast(r1, ContactEntity.class, "com.obric.memorydata.plugin")).getName(), CharSequence.class, "com.obric.memorydata.plugin")).length();
    L10:
        return r6;
    }

    public final Pair<List<AppEntity>, List<MetaValue>> a(List<? extends AppEntity> r4, ComponentName r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Pair<List<AppEntity>, List<MetaValue>> r0 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        if (r5 != null) goto L6;
        return r0;
    L6:
        if (Intrinsics.areEqual(r5, RealTimeContextService.Companion.a()) == false) goto L9;
        return a(r6);
    L9:
        if (Intrinsics.areEqual(r5, RealTimeContextService.Companion.b()) == false) goto L12;
        return b(r6);
    L12:
        if (Intrinsics.areEqual(r5, RealTimeContextService.Companion.c()) == true) goto L14;
        return r0;
    L14:
        return c(r6);
    }
}
