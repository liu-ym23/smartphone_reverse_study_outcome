package i4;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import x4.b0;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f8196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f8198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f8199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f8200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f8201g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f8202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f8203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b0 f8205d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8206e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ExecutorService f8207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b f8208g;
    }

    public e(a r8) {
        this.f8197c = 60000;
        this.f8195a = r8.f8202a;
        this.f8196b = r8.f8203b;
        this.f8197c = r8.f8204c;
        this.f8198d = r8.f8205d;
        this.f8200f = r8.f8206e;
        this.f8199e = r8.f8207f;
        this.f8201g = r8.f8208g;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("MonitorV3Config{context=");
        r8.append(this.f8195a);
        r8.append(", appLogConfig=");
        r8.append(this.f8196b);
        r8.append(", eventReportInterval=");
        r8.append(this.f8197c);
        r8.append(", networkClient=");
        r8.append(this.f8198d);
        r8.append(", executor=");
        r8.append(this.f8199e);
        r8.append(", reportUrl='");
        return android.aimedia.a.i(r8, this.f8200f, "'}");
    }
}
