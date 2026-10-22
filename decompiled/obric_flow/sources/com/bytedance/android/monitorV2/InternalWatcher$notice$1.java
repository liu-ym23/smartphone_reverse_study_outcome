package com.bytedance.android.monitorV2;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nInternalWatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InternalWatcher.kt\ncom/bytedance/android/monitorV2/InternalWatcher$notice$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,104:1\n181#2,2:105\n181#2,2:107\n*E\n*S KotlinDebug\n*F\n+ 1 InternalWatcher.kt\ncom/bytedance/android/monitorV2/InternalWatcher$notice$1\n*L\n82#1,2:105\n88#1,2:107\n*E\n"})
final class InternalWatcher$notice$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f3514c;
    public final /* synthetic */ Map d;

    public InternalWatcher$notice$1(String r5, String r10, Map r11, Map r12) {
        this.f3512a = r5;
        this.f3513b = r10;
        this.f3514c = r11;
        this.d = r12;
        super(0);
    }

    public final void a() {
        Map r5 = (Map) i.f3604a.get(this.f3512a);
        JSONObject r10 = com.lynx.tasm.utils.d.k(WsConstants.KEY_SDK_VERSION, "9.0.0");
        if (r5 == null) goto L8;
        Iterator r11 = r5.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put((String) r12.getKey(), r12.getValue());
    L8:
        Map r13 = this.f3514c;
        if (r13 == null) goto L14;
        Iterator r14 = r13.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        r10.put((String) r15.getKey(), r15.getValue());
    L14:
        JSONObject r16 = new JSONObject();
        Map r17 = this.d;
        if (r17 == null) goto L20;
        Iterator r18 = r17.entrySet().iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        Map.Entry r19 = (Map.Entry) r18.next();
        r16.put((String) r19.getKey(), r19.getValue());
    L20:
        com.bytedance.framwork.core.sdkmonitor.f.b("8560").p(this.f3513b, r10, r16, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        a();
        return Unit.INSTANCE;
    }
}
