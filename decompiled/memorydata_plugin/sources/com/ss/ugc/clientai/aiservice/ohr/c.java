package com.ss.ugc.clientai.aiservice.ohr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictObserver;", "", "onOHRPredictChanged", "", "result", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictResult;", "onOHRPredictStatus", "status", "", "Companion", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public interface c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f15788b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictObserver$Companion;", "", "()V", "STATUS_ERROR", "", "getSTATUS_ERROR", "()I", "STATUS_SHUTDOWN", "getSTATUS_SHUTDOWN", "STATUS_STARTUP", "getSTATUS_STARTUP", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15789a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f15790b = 0;
        private static final int c = 0;
        private static final int d = 0;

        static {
            f15789a = new a();
            c = -1;
            d = -2;
        }

        private a() {
        }

        public final int a() {
            return f15790b;
        }

        public final int b() {
            return d;
        }
    }

    static {
        f15788b = a.f15789a;
    }

    void a(int r1);

    void a(d r1);
}
