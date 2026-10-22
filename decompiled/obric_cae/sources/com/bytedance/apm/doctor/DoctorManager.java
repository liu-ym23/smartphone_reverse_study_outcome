package com.bytedance.apm.doctor;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3760a;

    public interface ApmListener {
        void onDataEvent(int r8, String r10, JSONObject r11);

        void onEvent(String r8, String r10);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoctorManager f3761a = null;

        static {
            f3761a = new DoctorManager();
        }
    }

    public DoctorManager() {
        this.f3760a = new ArrayList();
    }

    public static DoctorManager getInstance() {
        return a.f3761a;
    }
}
