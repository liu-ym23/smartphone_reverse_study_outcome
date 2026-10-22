package android.support.v4.media;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    b mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;

    public d() {
        this.mConnectionCallbackObj = new g(new c(this));
    }

    public abstract void onConnected();

    public abstract void onConnectionFailed();

    public abstract void onConnectionSuspended();

    public void setInternalConnectionCallback(b r5) {
        this.mConnectionCallbackInternal = r5;
    }
}
