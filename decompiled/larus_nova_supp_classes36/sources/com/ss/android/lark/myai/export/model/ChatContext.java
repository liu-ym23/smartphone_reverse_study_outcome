package com.ss.android.lark.myai.export.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/ChatContext;", "Landroid/os/Parcelable;", "extraMap", "", "", "aiSceneObject", "Lcom/ss/android/lark/myai/export/model/AISceneObject;", "<init>", "(Ljava/util/Map;Lcom/ss/android/lark/myai/export/model/AISceneObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtraMap", "()Ljava/util/Map;", "getAiSceneObject", "()Lcom/ss/android/lark/myai/export/model/AISceneObject;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "CREATOR", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatContext implements Parcelable {
    public static final a CREATOR = null;
    public final Map<String, String> a;
    public final osb.a b;

    public static final class a implements Parcelable.Creator<ChatContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatContext createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Intrinsics.checkNotNullParameter(r8, "parcel");
            ChatContext.CREATOR.getClass();
            Bundle r0 = r8.readBundle(Bundle.class.getClassLoader());
            if (r0 != null) goto L5;
            r0 = new Bundle();
        L5:
            LinkedHashMap r2 = new LinkedHashMap();
            Iterator<T> r3 = r0.keySet().iterator();
        L6:
            String r5 = "";
            if (r3.hasNext() == false) goto L9;
            String r4 = (String) r3.next();
            r2.put(r4, r0.getString(r4, ""));
            goto L6
        L9:
            ChatContext.CREATOR.getClass();
            String r1 = r8.readString();
            String r9 = r8.readString();
            boolean r6 = false;
            if (r1 != null) goto L12;
        L15:
            boolean r7 = true;
        L16:
            if (r7 == false) goto L24;
            if (r9 != null) goto L19;
        L20:
            r6 = true;
        L21:
            if (r6 == false) goto L24;
            osb.a r10 = null;
        L31:
            return new ChatContext(r2, r10);
        L19:
            if (r9.length() != 0) goto L21;
        L24:
            if (r1 != null) goto L26;
            r1 = "";
        L26:
            if (r9 == null) goto L29;
            r5 = r9;
        L29:
            r10 = new osb.a(r1, r5);
            goto L31
        L12:
            if (r1.length() == 0) goto L15;
            r7 = false;
            goto L16
        }

        @Override // android.os.Parcelable.Creator
        public final ChatContext[] newArray(int r1) {
            return new ChatContext[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatContext) == true) goto L8;
        return false;
    L8:
        ChatContext r6 = (ChatContext) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        osb.a r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChatContext(extraMap=" + this.a + ", aiSceneObject=" + this.b + ')';
    }

    public ChatContext(Map<String, String> r2, osb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "extraMap");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        Bundle r6 = new Bundle();
        Iterator<Map.Entry<String, String>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        r6.putString(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r4.writeBundle(r6);
        osb.a r7 = this.b;
        String r2 = null;
        if (r7 == null) goto L9;
        String r8 = r7.a;
    L10:
        r4.writeString(r8);
        osb.a r9 = this.b;
        if (r9 == null) goto L13;
        r2 = r9.b;
    L13:
        r4.writeString(r2);
        return;
    L9:
        r8 = null;
        goto L10
    }
}
