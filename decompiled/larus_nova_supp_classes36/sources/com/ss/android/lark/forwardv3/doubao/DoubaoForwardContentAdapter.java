package com.ss.android.lark.forwardv3.doubao;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.plugins.h;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\fJ\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016R\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/ss/android/lark/forwardv3/doubao/DoubaoForwardContentAdapter;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "Lcom/ss/android/lark/forwardv3/plugins/IForwardContentPluginProvider;", "<init>", "()V", "content", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "sessionId", "", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "getSessionId", "()J", "textContent", "", "getTextContent", "()Ljava/lang/String;", "setTextContent", "(Ljava/lang/String;)V", "previewText", "getPreviewText", "setPreviewText", "doubaoMsgIds", "", "getDoubaoMsgIds", "()Ljava/util/List;", "setDoubaoMsgIds", "(Ljava/util/List;)V", "", "hasDoubaoData", "getHasDoubaoData", "()Z", "", "doubaoDataSize", "getDoubaoDataSize", "()I", "createForwardPlugin", "Lcom/ss/android/lark/forwardv3/plugins/IForwardPlugin;", "rootFragment", "Landroidx/fragment/app/Fragment;", "toForwardDoubaoContent", "writeToParcel", "", "flags", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoForwardContentAdapter implements IForwardContent, h {
    public static final a CREATOR = null;
    public final long a;
    public final String b;
    public final String c;
    public final List<Long> d;
    public final boolean e;
    public final int f;

    public static final class a implements Parcelable.Creator<DoubaoForwardContentAdapter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardContentAdapter createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new DoubaoForwardContentAdapter(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardContentAdapter[] newArray(int r1) {
            return new DoubaoForwardContentAdapter[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoForwardContentAdapter() {
        this.b = "";
        this.c = "";
        this.d = CollectionsKt.emptyList();
    }

    public DoubaoForwardContentAdapter(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this();
        this.a = r4.readLong();
        String r0 = r4.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.b = r0;
        long[] r2 = r4.createLongArray();
        if (r2 == null) goto L9;
        List<Long> r3 = ArraysKt.toList(r2);
        if (r3 == null) goto L9;
    L10:
        this.d = r3;
        boolean r5 = true;
        if (r4.readInt() == 1) goto L14;
        r5 = false;
    L14:
        this.e = r5;
        this.f = r4.readInt();
        String r6 = r4.readString();
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        this.c = r1;
        return;
    L9:
        r3 = CollectionsKt.emptyList();
        goto L10
    }

    @Override // com.ss.android.lark.forwardv3.plugins.h
    public final b a(final Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "rootFragment");
        if (this.a != 0) goto L7;
        return null;
    L7:
        return new b(this.a, new DoubaoForwardContentAdapter$createForwardPlugin$1(r6));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeLong(this.a);
        r3.writeString(this.b);
        r3.writeLongArray(CollectionsKt.toLongArray(this.d));
        r3.writeInt(this.e ? 1 : 0);
        r3.writeInt(this.f);
        r3.writeString(this.c);
    }
}
