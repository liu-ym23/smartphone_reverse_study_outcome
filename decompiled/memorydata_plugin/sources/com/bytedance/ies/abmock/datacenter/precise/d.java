package com.bytedance.ies.abmock.datacenter.precise;

import com.bytedance.ies.abmock.datacenter.storage.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001b\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001a\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/VidExposureDelegate;", "Lcom/bytedance/ies/abmock/datacenter/precise/IVidExposureHandler;", "dataStorage", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "exposedVidsStoreKey", "", "(Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;Ljava/lang/String;)V", "currentUid", "extraDidExposureHandler", "Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler;", "extraUidExposureHandler", "appendExposureVids", "", "vids", "", "isUid", "", "([Ljava/lang/String;Z)V", "checkAndClearExposureVids", "allVids", "([Ljava/lang/String;)V", "clearExposureVids", "getExposureVids", "()[Ljava/lang/String;", "getExtraUidExposureHandler", "newExposureHandler", "storageKey", "vidsStringToList", "", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2702b;
    private volatile String c;
    private volatile com.bytedance.ies.abmock.datacenter.precise.a d;
    private final com.bytedance.ies.abmock.datacenter.precise.a e;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/bytedance/ies/abmock/datacenter/precise/VidExposureDelegate$newExposureHandler$vidStorage$1", "Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler$IVidStorage;", "loadVids", "", "", "()[Ljava/lang/String;", "saveVids", "", "vids", "([Ljava/lang/String;)V", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2704b;

        a(d r1, String r2) {
            this.f2703a = r1;
            this.f2704b = r2;
        }

        @Override // com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a
        public void a(String[] r2) {
            Intrinsics.checkNotNullParameter(r2, "vids");
            d.a(this.f2703a).b(this.f2704b, r2);
        }

        @Override // com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a
        public String[] a() {
            String[] r2 = d.a(this.f2703a).a(this.f2704b, new String[0]);
            Intrinsics.checkNotNullExpressionValue(r2, "dataStorage.getStringArr…geKey, arrayOf<String>())");
            return r2;
        }
    }

    public d(e r3, String r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dataStorage");
        Intrinsics.checkNotNullParameter(r4, "exposedVidsStoreKey");
        this.f2701a = r5;
        this.f2702b = r4;
        this.e = b(r4);
    }

    public static final /* synthetic */ e a(d r0) {
        return r0.f2701a;
    }

    private final com.bytedance.ies.abmock.datacenter.precise.a b() {
        String r0 = c.f2698a.a();
        if (Intrinsics.areEqual(this.c, r0) == true) goto L6;
        this.c = r0;
        this.d = b('{' + this.f2702b + "}_{" + this.c + '}');
    L6:
        return this.d;
    }

    private final com.bytedance.ies.abmock.datacenter.precise.a b(String r3) {
        return new com.bytedance.ies.abmock.datacenter.precise.a((com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a) ZeusTransformUtils.preCheckCast(new a(this, r3), com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a.class, "com.obric.memorydata.plugin"));
    }

    private final List<String> c(String r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L31;
        List r12 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);
        if (r12 == null) goto L32;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r10.iterator();
    L16:
        if (r14.hasNext() == false) goto L24;
        Object r1 = r14.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L16;
        r13.add(r1);
        goto L16
    L20:
        r4 = false;
        goto L21
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L32:
        return null;
    L31:
        return null;
    L7:
        r0 = false;
        goto L8
    }

    public void a(String r2) {
        List<String> r3 = c(r2);
        if (r3 == null) goto L7;
        this.e.a(r3);
        com.bytedance.ies.abmock.datacenter.precise.a r1 = b();
        if (r1 == null) goto L7;
        r1.a(r3);
    L7:
        c.f2698a.e();
    }

    public String[] a() {
        String[] r0 = this.e.a();
        com.bytedance.ies.abmock.datacenter.precise.a r2 = b();
        if (r2 == null) goto L9;
        String[] r3 = r2.a();
        if (r3 == null) goto L9;
        return (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r0, r3), String[].class, "com.obric.memorydata.plugin");
    L9:
        return r0;
    }
}
