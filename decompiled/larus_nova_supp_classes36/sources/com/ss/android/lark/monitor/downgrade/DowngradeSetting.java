package com.ss.android.lark.monitor.downgrade;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "downgrade_settings")
public class DowngradeSetting {

    @SerializedName("cpu_valve")
    public a cpuValve;

    @SerializedName("memory_valve")
    public b memoryValve;

    @SerializedName("temperature_valve")
    public c temperatureValve;

    public static class a {

        @SerializedName("common")
        public C0185a commonValve;

        @SerializedName("high_device")
        public C0185a highDeviceValve;

        @SerializedName("low_device")
        public C0185a lowDeviceValve;

        @SerializedName("middle_device")
        public C0185a middleDeviceValve;

        /* JADX INFO: renamed from: com.ss.android.lark.monitor.downgrade.DowngradeSetting$a$a, reason: collision with other inner class name */
        public static class C0185a {

            @SerializedName("busy_cpu_usage")
            public int BUSY_USAGE;

            @SerializedName("cpu_check_time")
            public int CPU_CHECK_TIME;

            @SerializedName("normal_cpu_usage")
            public int NORMAL_USAGE;

            public C0185a() {
                this.BUSY_USAGE = 25;
                this.NORMAL_USAGE = 10;
                this.CPU_CHECK_TIME = 10;
            }
        }

        public a() {
        }
    }

    public static class b {

        @SerializedName("common")
        public a commonValve;

        @SerializedName("high_device")
        public a highDeviceValve;

        @SerializedName("low_device")
        public a lowDeviceValve;

        @SerializedName("middle_device")
        public a middleDeviceValve;

        public static class a {

            @SerializedName("light_java_memory")
            public float LIGHT_JAVA_MEMORY;

            @SerializedName("middle_java_memory")
            public float MIDDLE_JAVA_MEMORY;

            @SerializedName("severe_java_memory")
            public float SEVERE_JAVA_MEMORY;

            public a() {
                this.SEVERE_JAVA_MEMORY = 30.0f;
                this.MIDDLE_JAVA_MEMORY = 50.0f;
                this.LIGHT_JAVA_MEMORY = 70.0f;
            }
        }

        public b() {
        }
    }

    public static class c {

        @SerializedName("common")
        public a commonValve;

        @SerializedName("high_device")
        public a highDeviceValve;

        @SerializedName("low_device")
        public a lowDeviceValve;

        @SerializedName("middle_device")
        public a middleDeviceValve;

        public static class a {

            @SerializedName("high_temperature")
            public int HIGH_TEMPERATURE;

            @SerializedName("light_temperature")
            public int LIGHT_TEMPERATURE;

            @SerializedName("middle_temperature")
            public int MIDDLE_TEMPERATURE;

            public a() {
                this.LIGHT_TEMPERATURE = 36;
                this.MIDDLE_TEMPERATURE = 38;
                this.HIGH_TEMPERATURE = 40;
            }
        }

        public c() {
        }
    }

    public DowngradeSetting() {
    }
}
