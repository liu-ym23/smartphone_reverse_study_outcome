package com.obric.memorydata.screencapture.a;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/screencapture/utils/ViewTreeTraversalGuard;", ExifInterface.GPS_DIRECTION_TRUE, "", "maxDepth", "", "<init>", "(I)V", "visited", "", "shouldVisit", "", "node", "depth", "(Ljava/lang/Object;I)Z", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<T> f12767b;

    public a(int r3) {
        this.f12766a = r3;
        this.f12767b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(T r2, int r3) {
        if (r3 < this.f12766a) goto L5;
    L7:
        return false;
    L5:
        if (this.f12767b.add(r2) == false) goto L7;
        return true;
    }
}
