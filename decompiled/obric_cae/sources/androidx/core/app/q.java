package androidx.core.app;

import android.app.RemoteInput;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    public static class a {
        public static int a(Object r8) {
            return ((RemoteInput) r8).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder r8, int r10) {
            return r8.setEditChoicesBeforeSending(r10);
        }
    }

    public static RemoteInput a(q r8) {
        r8.getClass();
        RemoteInput.Builder r10 = new RemoteInput.Builder(null).setLabel(null).setChoices(null).setAllowFreeFormInput(false).addExtras(null);
        a.b(r10, 0);
        return r10.build();
    }
}
