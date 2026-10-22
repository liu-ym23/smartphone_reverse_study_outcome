package com.larus.bach.impl;

import android.net.Uri;
import android.util.LruCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001f\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/bach/impl/BachDetectCenterAbilityImpl;", "Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "<init>", "()V", "enableBachDetect", "", "detectAvatarUri", "", "uri", "Landroid/net/Uri;", "searchBachDetectResult", MemoryActionTag.MEMORY_ACTION_TAG_REMOVE, "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "cancelBachDetectTask", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BachDetectCenterAbilityImpl implements IBachDetectCenterAbility {

    public static final class a {
    }

    static {
    }

    public BachDetectCenterAbilityImpl() {
    }

    public final boolean b() {
        return z2.a.enableLocalFaceDetect();
    }

    public final void a(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        if (b() == true) goto L6;
        FLogger.a.i("BachDetectCenterAbilityImpl", "[detectAvatarUri] enableBachDetect = false, return");
        return;
    L6:
        LruCache<String, Boolean> r0 = e.a;
        e.b(r3);
    }

    public final void d(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        if (b() == true) goto L6;
        FLogger.a.i("BachDetectCenterAbilityImpl", "[cancelBachDetectTask] enableBachDetect = false, return");
        return;
    L6:
        LruCache<String, Boolean> r0 = e.a;
        e.a(r3);
    }

    public final Boolean c(Uri r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        if (b() == true) goto L6;
        FLogger.a.i("BachDetectCenterAbilityImpl", "[searchBachDetectResult] enableBachDetect = false, return");
        return null;
    L6:
        LruCache<String, Boolean> r1 = e.a;
        Intrinsics.checkNotNullParameter(r6, "uri");
        LruCache<String, Boolean> r0 = e.a;
        Boolean r2 = r0.get(r6.toString());
        if (r2 != null) goto L11;
        String r3 = e.c.get(r6.toString());
        if (r3 == null) goto L11;
        Uri r4 = y0.j(r3);
        Boolean r5 = r0.get(r3);
        boolean r8 = true;
    L12:
        if (r7 == false) goto L16;
        if (r4 == null) goto L15;
        e.a(r4);
    L15:
        r0.remove(r6.toString());
        e.c.remove(r6.toString());
    L16:
        FLogger.a.i("BachDetectCenterManager", "[searchBachDetectResult] result: " + r5 + ", remove: " + r7 + ", hasRedirect = " + r8 + ", taskUri: " + r4);
        return r5;
    L11:
        r8 = false;
        r5 = r2;
        r4 = r6;
        goto L12
    }

    public final void e(Uri r4, Uri r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "oldUri");
        Intrinsics.checkNotNullParameter(r5, "newUri");
        LruCache<String, Boolean> r1 = e.a;
        Intrinsics.checkNotNullParameter(r4, "oldUri");
        Intrinsics.checkNotNullParameter(r5, "newUri");
        if (e.b.get(r4.toString()) == null) goto L5;
        e.c.put(r5.toString(), r4.toString());
        FLogger.a.i("BachDetectCenterManager", "[redirectDetectUri] success oldUri: " + r4 + ", newUri: " + r5);
        return;
    L5:
        e.b(r5);
        FLogger.a.i("BachDetectCenterManager", "[redirectDetectUri] failed tryDetect: true, newUri: " + r5);
    }
}
