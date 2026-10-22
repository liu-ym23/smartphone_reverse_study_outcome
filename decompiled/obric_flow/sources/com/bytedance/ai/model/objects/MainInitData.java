package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.i;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ai/model/objects/MainInitData;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "app", "Z", "getApp", "()Z", "setApp", "(Z)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/ArrayList;", "getService", "()Ljava/util/ArrayList;", "setService", "(Ljava/util/ArrayList;)V", "CREATOR", "w2/i", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MainInitData implements Parcelable {
    public static final i CREATOR = null;
    private boolean app;
    private ArrayList<String> service;

    static {
        CREATOR = new i();
    }

    public MainInitData() {
        this.service = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getApp() {
        return this.app;
    }

    public final ArrayList<String> getService() {
        return this.service;
    }

    public final void setApp(boolean r5) {
        this.app = r5;
    }

    public final void setService(ArrayList<String> r5) {
        this.service = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeByte(this.app ? 1 : 0);
        r5.writeStringList(this.service);
    }

    public MainInitData(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        if (r5.readByte() == 0) goto L5;
        boolean r10 = true;
    L6:
        this.app = r10;
        this.service = r5.createStringArrayList();
        return;
    L5:
        r10 = false;
        goto L6
    }
}
