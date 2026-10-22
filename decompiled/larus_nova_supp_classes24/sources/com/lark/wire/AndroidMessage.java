package com.lark.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.lark.wire.Message;
import com.lark.wire.Message.a;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \u0014*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00022\u00020\u0005:\u0002\u0013\u0014B\u001f\b\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016¨\u0006\u0015"}, d2 = {"Lcom/lark/wire/AndroidMessage;", "M", "Lcom/lark/wire/Message;", "B", "Lcom/lark/wire/Message$Builder;", "Landroid/os/Parcelable;", "adapter", "Lcom/lark/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/wire/ProtoAdapter;Lokio/ByteString;)V", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "describeContents", "ProtoAdapterCreator", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.a<M, B>> extends Message<M, B> implements Parcelable {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b<M> implements Parcelable.Creator<M> {
        public final ProtoAdapter<M> a;

        public b(ProtoAdapter<M> r2) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
            this.a = r2;
        }

        @Override // android.os.Parcelable.Creator
        public final M createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "input");
            return this.a.e(r2.createByteArray());
        }

        @Override // android.os.Parcelable.Creator
        public final M[] newArray(int r2) {
            KClass<?> r0 = this.a.getType();
            if (r0 == null) goto L5;
            Class r1 = JvmClassMappingKt.getJavaObjectType(r0);
        L6:
            Object r3 = Array.newInstance(r1, r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Array<M of com.lark.wire.AndroidMessage.ProtoAdapterCreator>");
            return (M[]) ((Object[]) r3);
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JvmStatic
    public static final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "adapter");
        return new b(r1);
    }

    public AndroidMessage(ProtoAdapter<M> r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "unknownFields");
        super(r2, r3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeByteArray(encode());
    }
}
