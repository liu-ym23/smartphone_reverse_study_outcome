package com.obric.contactsdk;

import android.net.Uri;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/contactsdk/ContactChange;", "", "()V", "listenerChangeList", "Ljava/util/ArrayList;", "Lcom/obric/contactsdk/ContactChangeListener;", "Lkotlin/collections/ArrayList;", "addChangeListener", "", "listener", "removeChangeListener", BuildConfig.CHANNEL, "uris", "", "Landroid/net/Uri;", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<e> f7854b = null;

    static {
        f7853a = new d();
        f7854b = new ArrayList();
    }

    private d() {
    }

    public final void update(List<? extends Uri> r4) {
        List<? extends Uri> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uris");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(f7854b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r5.next(), e.class, "com.obric.memorydata.plugin")).update(r3);
        goto L4
    }
}
