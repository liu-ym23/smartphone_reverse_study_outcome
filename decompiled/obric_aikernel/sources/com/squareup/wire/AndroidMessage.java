package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    private static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        ProtoAdapterCreator(ProtoAdapter<M> r10) {
            this.adapter = r10;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r10) {
            return this.adapter.decode(r10.createByteArray());
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r10) {
            return (M[]) ((Object[]) Array.newInstance(this.adapter.javaType, r10));
        }
    }

    protected AndroidMessage(ProtoAdapter<M> r10, ByteString r11) {
        super(r10, r11);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r10) {
        return new ProtoAdapterCreator(r10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r10, int r11) {
        r10.writeByteArray(encode());
    }
}
