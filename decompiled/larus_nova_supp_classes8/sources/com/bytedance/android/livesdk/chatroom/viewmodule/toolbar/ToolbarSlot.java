package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarSlot;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "", "items", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "", "collapsed", "Z", "c", "()Z", "collapseContainerId", "getCollapseContainerId", "<init>", "()V", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarSlot implements Comparable<ToolbarSlot> {

    @SerializedName("expand_item")
    private final String collapseContainerId;

    @SerializedName("expandable")
    private final boolean collapsed;

    @SerializedName("id")
    private final String id;

    @SerializedName("items")
    private final List<List<String>> items;

    @SerializedName("priority")
    private int priority;

    public static final class a {
    }

    static {
    }

    public ToolbarSlot() {
        this.id = "";
        this.items = new ArrayList();
        this.collapseContainerId = "";
    }

    public final boolean c() {
        return this.collapsed;
    }

    public final List<List<String>> d() {
        return this.items;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        if (b(new ToolbarSlot$contains$1(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String b(Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_PREDICTION);
        Iterator<T> r0 = this.items.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Iterator r1 = ((List) r0.next()).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        String r2 = (String) r1.next();
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L7;
        return r2;
    L11:
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ToolbarSlot r2) {
        ToolbarSlot r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        return this.priority - r3.priority;
    }

    public final void setPriority(int r1) {
        this.priority = r1;
    }
}
