package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    private static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        ProtoAdapterCreator(ProtoAdapter<M> r1) {
            this.adapter = r1;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r1) {
            return this.adapter.decode(r1.createByteArray());
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r2) {
            return (M[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(this.adapter.javaType, r2), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        }
    }

    public AndroidMessage(ProtoAdapter<M> r1, ByteString r2) {
        super(r1, r2);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r1) {
        return new ProtoAdapterCreator(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeByteArray(encode());
    }
}
