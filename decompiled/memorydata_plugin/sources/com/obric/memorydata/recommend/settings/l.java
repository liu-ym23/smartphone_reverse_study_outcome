package com.obric.memorydata.recommend.settings;

import android.content.Context;
import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangeNotifier;", "", "<init>", "()V", "publisher", "Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangePublisher;", "blockMemoryRuleChangePublisher", "Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleChangePublisher;", "notifyCellularChanged", "", "notifyBlockRulesInserted", "insertId", "", "notifyBlockRulesChanged", "changedRows", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12612a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final m f12613b = null;
    private static final e c = null;

    static {
        f12612a = new l();
        $$Lambda$l$ktkuISwTNkci3WXZEci2u1qWNiA r0 = $$Lambda$l$ktkuISwTNkci3WXZEci2u1qWNiA.INSTANCE;
        f12613b = r0;
        c = new e(r0);
    }

    private l() {
    }

    private static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse(r3), null, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$ktkuISwTNkci3WXZEci2u1qWNiA(String r0) {
        a(r0);
    }

    public final void a() {
        f12613b.publish("content://com.obric.memorydata.memory.ailabprovider/recorder_settings/cellular");
    }

    public final void a(int r1) {
        c.a(r1);
    }

    public final void a(long r1) {
        c.a(r1);
    }
}
