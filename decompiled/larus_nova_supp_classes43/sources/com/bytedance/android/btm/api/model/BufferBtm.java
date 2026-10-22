package com.bytedance.android.btm.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+BQ\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0 ¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b'\u0010)J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u001a\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/bytedance/android/btm/api/model/BufferBtm;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "toString", "btm", "Ljava/lang/String;", "getBtm", "()Ljava/lang/String;", "step", "I", "getStep", "()I", "pageId", "getPageId", "nodeId", "getNodeId", "treeId", "getTreeId", "btmShowId", "getBtmShowId", "useTimes", "getUseTimes", "setUseTimes", "(I)V", "", "targetPagesBtm", "Ljava/util/List;", "getTargetPagesBtm", "()Ljava/util/List;", "setTargetPagesBtm", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BufferBtm implements Parcelable, Serializable {
    public static final Parcelable.Creator<BufferBtm> CREATOR = null;
    public static final b Companion = null;
    private final String btm;
    private final String btmShowId;
    private final String nodeId;
    private final String pageId;
    private final int step;
    private List<String> targetPagesBtm;
    private final String treeId;
    private int useTimes;

    public static final class a implements Parcelable.Creator<BufferBtm> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BufferBtm createFromParcel(Parcel r10) {
            return new BufferBtm(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final BufferBtm[] newArray(int r1) {
            return new BufferBtm[r1];
        }
    }

    public static final class b {
        public b() {
        }

        public static BufferBtm a(BufferBtm r10) {
            return b(r10.getBtm(), r10.getStep(), r10.getPageId(), r10.getNodeId(), r10.getTreeId(), r10.getBtmShowId(), r10.getUseTimes(), r10.getTargetPagesBtm());
        }

        public static /* synthetic */ BufferBtm c(b r10, String r11, int r12, String r13, String r14, String r15, String r16) {
            ArrayList r17 = new ArrayList();
            r10.getClass();
            return b(r11, r12, r13, r14, r15, r16, 1, r17);
        }

        public static BufferBtm b(String r10, int r11, String r12, String r13, String r14, String r15, int r16, List r17) {
            if (r13 == null) goto L5;
            String r18 = r13;
        L6:
            if (r14 == null) goto L8;
            String r19 = r14;
        L10:
            return new BufferBtm(r10, r11, r12, r18, r19, r15, r16, r17);
        L8:
            r19 = "";
            goto L10
        L5:
            r18 = "";
            goto L6
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("btm", this.btm);     // Catch: Throwable -> L10
        r0.put("step", this.step);     // Catch: Throwable -> L10
        r0.put("pageId", this.pageId);     // Catch: Throwable -> L10
        r0.put("nodeId", this.nodeId);     // Catch: Throwable -> L10
        r0.put("treeId", this.treeId);     // Catch: Throwable -> L10
        r0.put("btmShowId", this.btmShowId);     // Catch: Throwable -> L10
        r0.put("useTimes", this.useTimes);     // Catch: Throwable -> L10
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L10
        Iterator<T> r10 = this.targetPagesBtm.iterator();     // Catch: Throwable -> L10
    L5:
        if (r10.hasNext() == false) goto L7;
        r1.put((String) r10.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        r0.put("targetPagesBtm", r1);     // Catch: Throwable -> L10
    L9:
        return r0.toString();
    }

    public final String getBtm() {
        return this.btm;
    }

    public final String getBtmShowId() {
        return this.btmShowId;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final int getStep() {
        return this.step;
    }

    public final List<String> getTargetPagesBtm() {
        return this.targetPagesBtm;
    }

    public final String getTreeId() {
        return this.treeId;
    }

    public final int getUseTimes() {
        return this.useTimes;
    }

    public BufferBtm(Parcel r14) {
        String r0 = r14.readString();
        if (r0 == null) goto L5;
        String r10 = r0;
    L6:
        int r11 = r14.readInt();
        String r1 = r14.readString();
        if (r1 == null) goto L9;
        String r12 = r1;
    L10:
        String r13 = r14.readString();
        if (r13 == null) goto L13;
        String r15 = r13;
    L14:
        String r16 = r14.readString();
        if (r16 == null) goto L17;
        String r17 = r16;
    L18:
        String r18 = r14.readString();
        if (r18 == null) goto L21;
        String r19 = r18;
    L22:
        this(r10, r11, r12, r15, r17, r19, r14.readInt(), null, 128, null);
        r14.readList(this.targetPagesBtm, String.class.getClassLoader());
        return;
    L21:
        r19 = "";
        goto L22
    L17:
        r17 = "";
        goto L18
    L13:
        r15 = "";
        goto L14
    L9:
        r12 = "";
        goto L10
    L5:
        r10 = "";
        goto L6
    }

    public final void setTargetPagesBtm(List<String> r1) {
        this.targetPagesBtm = r1;
    }

    public final void setUseTimes(int r1) {
        this.useTimes = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        r1.writeString(this.btm);
        r1.writeInt(this.step);
        r1.writeString(this.pageId);
        r1.writeString(this.nodeId);
        r1.writeString(this.treeId);
        r1.writeString(this.btmShowId);
        r1.writeInt(this.useTimes);
        r1.writeList(this.targetPagesBtm);
    }

    public BufferBtm(String r1, int r10, String r11, String r12, String r13, String r14, int r15, List<String> r16) {
        this.btm = r1;
        this.step = r10;
        this.pageId = r11;
        this.nodeId = r12;
        this.treeId = r13;
        this.btmShowId = r14;
        this.useTimes = r15;
        this.targetPagesBtm = r16;
        this.useTimes = Math.max(r15, 1);
    }

    public /* synthetic */ BufferBtm(String r12, int r13, String r14, String r15, String r16, String r17, int r18, List r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 64) == 0) goto L5;
        int r10 = 1;
    L7:
        if ((r20 & 128) == 0) goto L9;
        List r11 = new ArrayList();
    L10:
        this(r12, r13, r14, r15, r16, r17, r10, r11);
        return;
    L9:
        r11 = r19;
        goto L10
    L5:
        r10 = r18;
        goto L7
    }
}
