package com.bytedance.geckox.model;

import androidx.annotation.Keep;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J'\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u0013R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/geckox/model/Resources;", "", "groups", "", "", "channels", "([Ljava/lang/String;[Ljava/lang/String;)V", "()V", "", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "isHit", "", "group", LynxMonitorService.KEY_CHANNEL, "isHit$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class Resources {
    private List<String> channels;
    private List<String> groups;

    public Resources() {
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final boolean isHit$geckox_noasanRelease(List<String> r5, String r10) {
        List<String> r11 = this.groups;
        if (r11 != null) goto L5;
    L6:
        List<String> r12 = this.channels;
        if (r12 != null) goto L9;
    L47:
        return true;
    L9:
        if (r12.isEmpty() == true) goto L47;
    L11:
        if (r10 == null) goto L23;
        List<String> r13 = this.channels;
        if (r13 == null) goto L23;
        if (r13.isEmpty() == true) goto L23;
        List<String> r14 = this.channels;
        if (r14 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        if (r14.contains(r10) == false) goto L23;
        return true;
    L23:
        if (r5 == null) goto L45;
        List<String> r15 = this.groups;
        if (r15 != null) goto L27;
        return false;
    L27:
        if (r15.isEmpty() == true) goto L53;
        List<String> r16 = this.groups;
        if (r16 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        Iterator<T> r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L38;
        Object r18 = r17.next();
        if (r5.contains((String) r18) == false) goto L34;
    L39:
        CharSequence r19 = (CharSequence) r18;
        if (r19 != null) goto L42;
        return false;
    L42:
        if (r19.length() == 0) goto L54;
        return true;
    L54:
        return false;
    L38:
        r18 = null;
        goto L39
    L53:
        return false;
    L45:
        return false;
    L5:
        if (r11.isEmpty() == false) goto L11;
        goto L6
    }

    public final void setChannels(List<String> r5) {
        this.channels = r5;
    }

    public final void setGroups(List<String> r5) {
        this.groups = r5;
    }

    public Resources(String[] r5, String[] r10) {
        this();
        List<String> r11 = null;
        if (r5 == null) goto L5;
        List<String> r12 = ArraysKt.asList(r5);
    L6:
        this.groups = r12;
        if (r10 == null) goto L9;
        r11 = ArraysKt.asList(r10);
    L9:
        this.channels = r11;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
