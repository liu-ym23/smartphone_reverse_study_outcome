package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    public static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(ProtoAdapter<M> r5) {
            this.adapter = r5;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r5) {
            return this.adapter.decode(r5.createByteArray());
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r5) {
            return (M[]) ((Object[]) Array.newInstance(this.adapter.javaType, r5));
        }
    }

    public AndroidMessage(ProtoAdapter<M> r5, ByteString r10) {
        super(r5, r10);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r5) {
        return new ProtoAdapterCreator(r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeByteArray(encode());
    }
}
