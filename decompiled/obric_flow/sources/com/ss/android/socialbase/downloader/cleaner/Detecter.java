package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
public class Detecter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile CleanerImpl.AnonymousClass1 f15241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile DetecterState f15242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f15243c;
    public volatile Semaphore d;
    public final ExecutorService e;
    public volatile boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15244h;

    public static final enum DetecterState extends Enum<DetecterState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DetecterState f15249a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DetecterState f15250b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DetecterState f15251c = null;
        public static final /* synthetic */ DetecterState[] d = null;

        static {
            DetecterState r5 = new DetecterState("DETECTER_INIT", 0);
            f15249a = r5;
            DetecterState r10 = new DetecterState("DETECTER_STUCK", 1);
            f15250b = r10;
            DetecterState r11 = new DetecterState("DETECTER_SMOOTH", 2);
            f15251c = r11;
            d = new DetecterState[]{r5, r10, r11};
        }

        public DetecterState(String r5, int r10) {
            super(r5, r10);
        }

        public static DetecterState valueOf(String r5) {
            return (DetecterState) Enum.valueOf(DetecterState.class, r5);
        }

        public static DetecterState[] values() {
            return (DetecterState[]) d.clone();
        }
    }

    public Detecter(CleanerImpl.AnonymousClass1 r5) {
        this.f15242b = DetecterState.f15249a;
        this.f15243c = new Handler(Looper.getMainLooper());
        this.d = new Semaphore(0);
        this.e = Executors.newCachedThreadPool();
        this.f = false;
        this.g = 0;
        this.f15244h = 0;
        this.f15241a = r5;
    }
}
