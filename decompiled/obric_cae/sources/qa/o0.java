package qa;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static o0 f10865d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f10867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10868c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10871c;

        public a(String r8, String r10) {
            this.f10869a = null;
            this.f10870b = r8;
            this.f10871c = r10;
        }

        public a(URL r8) {
            this.f10869a = r8.getProtocol();
            this.f10870b = r8.getHost();
            this.f10871c = r8.getPath();
        }
    }

    public o0() {
        this.f10866a = new HashMap();
        this.f10867b = new HashMap();
        this.f10868c = new ArrayList();
    }
}
