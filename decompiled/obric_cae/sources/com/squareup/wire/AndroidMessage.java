package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import jf.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    public static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(ProtoAdapter<M> r8) {
            this.adapter = r8;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel r8) {
            return this.adapter.decode(r8.createByteArray());
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int r8) {
            return (M[]) ((Object[]) Array.newInstance(this.adapter.javaType, r8));
        }
    }

    public AndroidMessage(ProtoAdapter<M> r8, g r10) {
        super(r8, r10);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> r8) {
        return new ProtoAdapterCreator(r8);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeByteArray(encode());
    }
}
