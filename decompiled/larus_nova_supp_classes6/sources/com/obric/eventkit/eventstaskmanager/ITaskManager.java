package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ITaskManager extends IInterface {

    public static abstract class Stub extends Binder implements ITaskManager {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.ITaskManager";
        public static final int TRANSACTION_addConditionTask = 29;
        public static final int TRANSACTION_addEventTask = 43;
        public static final int TRANSACTION_addEventTaskExecutionDetailRecords = 65;
        public static final int TRANSACTION_addEventTaskExecutionRecords = 57;
        public static final int TRANSACTION_addTimerTask = 1;
        public static final int TRANSACTION_closeAssistantInputPanel = 17;
        public static final int TRANSACTION_getAllConditionTaskRecords = 34;
        public static final int TRANSACTION_getAllEventTaskRecords = 54;
        public static final int TRANSACTION_getAllEventTasks = 37;
        public static final int TRANSACTION_getAllTimerTaskRecords = 11;
        public static final int TRANSACTION_getAllTimerTasks = 9;
        public static final int TRANSACTION_getAssistantSessionState = 21;
        public static final int TRANSACTION_getAssistantTtsPlayingState = 22;
        public static final int TRANSACTION_getConditionTask = 31;
        public static final int TRANSACTION_getConditionTaskRecordsByTaskId = 33;
        public static final int TRANSACTION_getEventTask = 38;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecordById = 68;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecords = 66;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecordsBySessionId = 67;
        public static final int TRANSACTION_getEventTaskExecutionRecordById = 60;
        public static final int TRANSACTION_getEventTaskExecutionRecords = 58;
        public static final int TRANSACTION_getEventTaskExecutionRecordsByTaskId = 59;
        public static final int TRANSACTION_getEventTaskRecordsByTaskId = 53;
        public static final int TRANSACTION_getEventTasksByType = 48;
        public static final int TRANSACTION_getKnowledgeSessionIdNotNullEventTasks = 46;
        public static final int TRANSACTION_getNextScheduleTimeStamp = 7;
        public static final int TRANSACTION_getShortInstructNotNullShortcutTasks = 49;
        public static final int TRANSACTION_getTemplateIdNotNullEventTasks = 47;
        public static final int TRANSACTION_getTimerTask = 8;
        public static final int TRANSACTION_getTimerTaskByTaskId = 6;
        public static final int TRANSACTION_getTimerTaskRecordsByTaskId = 10;
        public static final int TRANSACTION_notifyAssistantState = 18;
        public static final int TRANSACTION_openAssistantInputPanel = 16;
        public static final int TRANSACTION_registerAssistantSessionState = 27;
        public static final int TRANSACTION_registerAssistantTtsPlayingState = 25;
        public static final int TRANSACTION_registerEventTaskChangeListener = 39;
        public static final int TRANSACTION_registerEventTaskScheduleListener = 41;
        public static final int TRANSACTION_registerTimerTaskChangeListener = 14;
        public static final int TRANSACTION_removeAllConditionTaskRecords = 36;
        public static final int TRANSACTION_removeAllEventTaskRecords = 56;
        public static final int TRANSACTION_removeAllTimeTaskRecords = 13;
        public static final int TRANSACTION_removeConditionTask = 30;
        public static final int TRANSACTION_removeConditionTaskRecordsById = 35;
        public static final int TRANSACTION_removeEventTask = 44;
        public static final int TRANSACTION_removeEventTaskExecutionDetailRecordsById = 71;
        public static final int TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId = 72;
        public static final int TRANSACTION_removeEventTaskExecutionRecordsById = 63;
        public static final int TRANSACTION_removeEventTaskExecutionRecordsByTaskId = 64;
        public static final int TRANSACTION_removeEventTaskRecordsById = 55;
        public static final int TRANSACTION_removeTimerTask = 3;
        public static final int TRANSACTION_removeTimerTaskRecordsById = 12;
        public static final int TRANSACTION_removeTimerTasksByTaskId = 2;
        public static final int TRANSACTION_requestSendMessage = 20;
        public static final int TRANSACTION_scheduleShortcutTask = 50;
        public static final int TRANSACTION_setAssistantInteractionListener = 19;
        public static final int TRANSACTION_skipConditionTaskSchedule = 51;
        public static final int TRANSACTION_skipTimerTasksByTaskId = 4;
        public static final int TRANSACTION_tryActiveAgent = 73;
        public static final int TRANSACTION_tryInterruptAssistant = 23;
        public static final int TRANSACTION_tryOpenMicToRecording = 24;
        public static final int TRANSACTION_tryScheduleConditionTask = 52;
        public static final int TRANSACTION_unRegisterAssistantSessionState = 28;
        public static final int TRANSACTION_unRegisterAssistantTtsPlayingState = 26;
        public static final int TRANSACTION_unregisterEventTaskChangeListener = 40;
        public static final int TRANSACTION_unregisterEventTaskScheduleListener = 42;
        public static final int TRANSACTION_unregisterTimerTaskChangeListener = 15;
        public static final int TRANSACTION_updateConditionTask = 32;
        public static final int TRANSACTION_updateEventTask = 45;
        public static final int TRANSACTION_updateEventTaskExecutionDetailRecord = 69;
        public static final int TRANSACTION_updateEventTaskExecutionDetailRecords = 70;
        public static final int TRANSACTION_updateEventTaskExecutionRecord = 61;
        public static final int TRANSACTION_updateEventTaskExecutionRecords = 62;
        public static final int TRANSACTION_updateTimerTask = 5;

        public static class Proxy implements ITaskManager {
            public static ITaskManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, Map r18) {
                Parcel r8 = Parcel.obtain();
                Parcel r9 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L29
                r8.writeTypedList(r13);     // Catch: Throwable -> L29
                r8.writeString(r14);     // Catch: Throwable -> L29
                if (r15 == null) goto L6;
                r8.writeInt(1);     // Catch: Throwable -> L29
                r15.writeToParcel(r8, 0);     // Catch: Throwable -> L29
            L7:
                if (r16 == null) goto L9;
                r8.writeInt(1);     // Catch: Throwable -> L29
                r16.writeToParcel(r8, 0);     // Catch: Throwable -> L29
            L10:
                if (r17 == null) goto L12;
                r8.writeInt(1);     // Catch: Throwable -> L29
                r17.writeToParcel(r8, 0);     // Catch: Throwable -> L29
            L13:
                r8.writeMap(r18);     // Catch: Throwable -> L29
            L27:
                th = th;
            L31:
                r9.recycle();
                r8.recycle();
                throw th;
            L16:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r8, r9, 0) == false) goto L18;
            L22:
                r9.readException();     // Catch: Throwable -> L27
                if (r9.readInt() == 0) goto L26;
                ConditionTaskResult r0 = ConditionTaskResult.CREATOR.createFromParcel(r9);     // Catch: Throwable -> L27
            L20:
                r9.recycle();
                r8.recycle();
                return r0;
            L26:
                r0 = null;
                goto L20
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                r0 = Stub.getDefaultImpl().addConditionTask(r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L27
                goto L20
            L12:
                r8.writeInt(0);     // Catch: Throwable -> L29
                goto L13
            L9:
                r8.writeInt(0);     // Catch: Throwable -> L29
                goto L10
            L6:
                r8.writeInt(0);     // Catch: Throwable -> L29
            L29:
                th = th;
                goto L31
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult addEventTask(EventTaskSpec r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 43, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r7 = EventTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r7 = Stub.getDefaultImpl().addEventTask(r6);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 65, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r7 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().addEventTaskExecutionDetailRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 57, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r7 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().addEventTaskExecutionRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult addTimerTask(TimerTask r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L12:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L16;
                TimerTaskResult.CREATOR.getClass();     // Catch: Throwable -> L19
                TimerTaskResult r7 = TimerTaskResult.a.a(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r7;
            L16:
                r7 = null;
                goto L17
            L10:
                if (Stub.getDefaultImpl() == null) goto L12;
                r7 = Stub.getDefaultImpl().addTimerTask(r6);     // Catch: Throwable -> L19
                goto L17
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void closeAssistantInputPanel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().closeAssistantInputPanel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ConditionTaskRecord> getAllConditionTaskRecords(long r6, long r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r6);     // Catch: Throwable -> L12
                r0.writeLong(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r7 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getAllConditionTaskRecords(r6, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskRecord> getAllEventTaskRecords(long r10, long r12, int r14) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r10);     // Catch: Throwable -> L12
                r0.writeLong(r12);     // Catch: Throwable -> L12
                r0.writeInt(r14);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 54, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r11 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getAllEventTaskRecords(r10, r12, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getAllEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 37, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r2 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getAllEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTaskRecord> getAllTimerTaskRecords(long r6, long r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r6);     // Catch: Throwable -> L12
                r0.writeLong(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r7 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getAllTimerTaskRecords(r6, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTask> getAllTimerTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r2 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getAllTimerTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int getAssistantSessionState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r2 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getAssistantSessionState();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int getAssistantTtsPlayingState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r2 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getAssistantTtsPlayingState();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTask getConditionTask(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTask r7 = ConditionTask.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getConditionTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r10, long r12, String r14) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r10);     // Catch: Throwable -> L12
                r0.writeLong(r12);     // Catch: Throwable -> L12
                r0.writeString(r14);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r11 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getConditionTaskRecordsByTaskId(r10, r12, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTask getEventTask(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 38, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTask r7 = EventTask.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getEventTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 68, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionDetailRecord r7 = EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecordById(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 66, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r8 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecords(r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r6, int r7, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                r0.writeInt(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 67, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r9 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r9 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecordsBySessionId(r6, r7, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 60, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionRecord r7 = EventTaskExecutionRecord.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getEventTaskExecutionRecordById(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 58, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r8 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getEventTaskExecutionRecords(r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r6, int r7, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                r0.writeInt(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 59, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r9 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r9 = Stub.getDefaultImpl().getEventTaskExecutionRecordsByTaskId(r6, r7, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r10, long r12, String r14) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r10);     // Catch: Throwable -> L12
                r0.writeLong(r12);     // Catch: Throwable -> L12
                r0.writeString(r14);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 53, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r11 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getEventTaskRecordsByTaskId(r10, r12, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getEventTasksByType(int r6, int r7, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                r0.writeInt(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 48, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r9 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r9 = Stub.getDefaultImpl().getEventTasksByType(r6, r7, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 46, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r2 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getKnowledgeSessionIdNotNullEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public long getNextScheduleTimeStamp(int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                long r2 = r1.readLong();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getNextScheduleTimeStamp(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 49, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ShortcutTask> r2 = r1.createTypedArrayList(ShortcutTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getShortInstructNotNullShortcutTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getTemplateIdNotNullEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 47, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r2 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().getTemplateIdNotNullEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTask> getTimerTask(Map r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeMap(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r7 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().getTimerTask(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r10, long r12, int r14) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r10);     // Catch: Throwable -> L12
                r0.writeLong(r12);     // Catch: Throwable -> L12
                r0.writeInt(r14);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r11 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getTimerTaskRecordsByTaskId(r10, r12, r14);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void notifyAssistantState(boolean r6, StateInfo r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyAssistantState(r6, r7);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void openAssistantInputPanel(StateInfo r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().openAssistantInputPanel(r6, r7);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerAssistantSessionState(IAssistantSessionStateListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAssistantSessionState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAssistantTtsPlayingState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerEventTaskChangeListener(IEventTaskChangeListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 39, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerEventTaskScheduleListener(IEventTaskScheduleListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 41, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventTaskScheduleListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerTimerTaskChangeListener(ITimerTaskChangeListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTimerTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllConditionTaskRecords() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 36, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r2 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().removeAllConditionTaskRecords();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllEventTaskRecords(int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 56, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeAllEventTaskRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllTimeTaskRecords() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r2 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r2 = Stub.getDefaultImpl().removeAllTimeTaskRecords();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult removeConditionTask(String[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeStringArray(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTaskResult r7 = ConditionTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeConditionTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeConditionTaskRecordsById(long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeConditionTaskRecordsById(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult removeEventTask(String[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeStringArray(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 44, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskResult r7 = EventTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeEventTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionDetailRecordsById(long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 71, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeEventTaskExecutionDetailRecordsById(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionDetailRecordsBySessionId(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 72, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeEventTaskExecutionDetailRecordsBySessionId(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionRecordsById(long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 63, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeEventTaskExecutionRecordsById(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionRecordsByTaskId(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 64, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeEventTaskExecutionRecordsByTaskId(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskRecordsById(int r6, long[] r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeLongArray(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 55, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r8 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().removeEventTaskRecordsById(r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult removeTimerTask(Map r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeMap(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L8:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L12;
                TimerTaskResult.CREATOR.getClass();     // Catch: Throwable -> L15
                TimerTaskResult r7 = TimerTaskResult.a.a(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r7;
            L12:
                r7 = null;
                goto L13
            L6:
                if (Stub.getDefaultImpl() == null) goto L8;
                r7 = Stub.getDefaultImpl().removeTimerTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeTimerTaskRecordsById(int[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeIntArray(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().removeTimerTaskRecordsById(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult removeTimerTasksByTaskId(int[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeIntArray(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L8:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L12;
                TimerTaskResult.CREATOR.getClass();     // Catch: Throwable -> L15
                TimerTaskResult r7 = TimerTaskResult.a.a(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r7;
            L12:
                r7 = null;
                goto L13
            L6:
                if (Stub.getDefaultImpl() == null) goto L8;
                r7 = Stub.getDefaultImpl().removeTimerTasksByTaskId(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void requestSendMessage(String r6, String r7, Map r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                r0.writeMap(r8);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestSendMessage(r6, r7, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void scheduleShortcutTask(String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 50, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().scheduleShortcutTask(r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void setAssistantInteractionListener(IAssistantInteractionListener r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAssistantInteractionListener(r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void skipConditionTaskSchedule(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 51, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().skipConditionTaskSchedule(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult skipTimerTasksByTaskId(int r6, long[] r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                r0.writeLongArray(r7);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L8:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L12;
                TimerTaskResult.CREATOR.getClass();     // Catch: Throwable -> L15
                TimerTaskResult r8 = TimerTaskResult.a.a(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r8;
            L12:
                r8 = null;
                goto L13
            L6:
                if (Stub.getDefaultImpl() == null) goto L8;
                r8 = Stub.getDefaultImpl().skipTimerTasksByTaskId(r6, r7);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryActiveAgent(AppEvent r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 73, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().tryActiveAgent(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryInterruptAssistant(AppEvent r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().tryInterruptAssistant(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryOpenMicToRecording(AppEvent r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().tryOpenMicToRecording(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void tryScheduleConditionTask(String r10, List<ConditionTaskAction> r11, TaskKnowledge r12, int r13, String r14) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r10);     // Catch: Throwable -> L16
                r0.writeTypedList(r11);     // Catch: Throwable -> L16
                if (r12 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r12.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r13);     // Catch: Throwable -> L16
                r0.writeString(r14);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 52, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().tryScheduleConditionTask(r10, r11, r12, r13, r14);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unRegisterAssistantSessionState(IAssistantSessionStateListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterAssistantSessionState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterAssistantTtsPlayingState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterEventTaskChangeListener(IEventTaskChangeListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 40, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 42, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventTaskScheduleListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTimerTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult updateConditionTask(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map r22) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L29
                r10.writeString(r15);     // Catch: Throwable -> L29
                r10.writeTypedList(r16);     // Catch: Throwable -> L29
                r10.writeString(r17);     // Catch: Throwable -> L29
                if (r18 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L29
                r18.writeToParcel(r10, 0);     // Catch: Throwable -> L29
            L7:
                if (r19 == null) goto L9;
                r10.writeInt(1);     // Catch: Throwable -> L29
                r19.writeToParcel(r10, 0);     // Catch: Throwable -> L29
            L10:
                if (r20 == null) goto L12;
                r10.writeInt(1);     // Catch: Throwable -> L29
                r20.writeToParcel(r10, 0);     // Catch: Throwable -> L29
            L13:
                r10.writeInt(r21);     // Catch: Throwable -> L29
                r10.writeMap(r22);     // Catch: Throwable -> L29
            L27:
                th = th;
            L31:
                r11.recycle();
                r10.recycle();
                throw th;
            L16:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r10, r11, 0) == false) goto L18;
            L22:
                r11.readException();     // Catch: Throwable -> L27
                if (r11.readInt() == 0) goto L26;
                ConditionTaskResult r0 = ConditionTaskResult.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L27
            L20:
                r11.recycle();
                r10.recycle();
                return r0;
            L26:
                r0 = null;
                goto L20
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                r0 = Stub.getDefaultImpl().updateConditionTask(r15, r16, r17, r18, r19, r20, r21, r22);     // Catch: Throwable -> L27
                goto L20
            L12:
                r10.writeInt(0);     // Catch: Throwable -> L29
                goto L13
            L9:
                r10.writeInt(0);     // Catch: Throwable -> L29
                goto L10
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L29
            L29:
                th = th;
                goto L31
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult updateEventTask(String r6, EventTaskSpec r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 45, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r8 = EventTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r8;
            L18:
                r8 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r8 = Stub.getDefaultImpl().updateEventTask(r6, r7);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 69, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionDetailRecord r7 = EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r7 = Stub.getDefaultImpl().updateEventTaskExecutionDetailRecord(r6);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 70, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().updateEventTaskExecutionDetailRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 61, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionRecord r7 = EventTaskExecutionRecord.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r7 = Stub.getDefaultImpl().updateEventTaskExecutionRecord(r6);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 62, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r7 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r7 = Stub.getDefaultImpl().updateEventTaskExecutionRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult updateTimerTask(TimerTask r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
            L12:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L16;
                TimerTaskResult.CREATOR.getClass();     // Catch: Throwable -> L19
                TimerTaskResult r7 = TimerTaskResult.a.a(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r7;
            L16:
                r7 = null;
                goto L17
            L10:
                if (Stub.getDefaultImpl() == null) goto L12;
                r7 = Stub.getDefaultImpl().updateTimerTask(r6);     // Catch: Throwable -> L19
                goto L17
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTask getTimerTaskByTaskId(int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
            L8:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L12;
                TimerTask.CREATOR.getClass();     // Catch: Throwable -> L15
                Intrinsics.checkNotNullParameter(r1, "parcel");     // Catch: Throwable -> L15
                TimerTask r7 = new TimerTask(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r7;
            L12:
                r7 = null;
                goto L13
            L6:
                if (Stub.getDefaultImpl() == null) goto L8;
                r7 = Stub.getDefaultImpl().getTimerTaskByTaskId(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_ITaskManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITaskManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ITaskManager) == false) goto L12;
            return (ITaskManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ITaskManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITaskManager r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r16, Parcel r17, Parcel r18, int r19) {
            if (r16 == 1598968902) goto L274;
            TimerTask r4 = null;
            AppEvent r5 = null;
            EventTaskExecutionDetailRecord r6 = null;
            EventTaskExecutionRecord r7 = null;
            TaskKnowledge r8 = null;
            EventTaskSpec r9 = null;
            EventTaskSpec r10 = null;
            AppEvent r11 = null;
            AppEvent r12 = null;
            StateInfo r13 = null;
            StateInfo r14 = null;
            TimerTask r15 = null;
            boolean r110 = false;
            switch(r16) {
                case 1: goto L266;
                case 2: goto L261;
                case 3: goto L256;
                case 4: goto L251;
                case 5: goto L243;
                case 6: goto L238;
                case 7: goto L236;
                case 8: goto L234;
                case 9: goto L232;
                case 10: goto L230;
                case 11: goto L228;
                case 12: goto L226;
                case 13: goto L224;
                case 14: goto L222;
                case 15: goto L220;
                case 16: goto L212;
                case 17: goto L210;
                case 18: goto L202;
                case 19: goto L200;
                case 20: goto L198;
                case 21: goto L196;
                case 22: goto L194;
                case 23: goto L189;
                case 24: goto L184;
                case 25: goto L182;
                case 26: goto L180;
                case 27: goto L178;
                case 28: goto L176;
                case 29: goto L159;
                case 30: goto L154;
                case 31: goto L149;
                case 32: goto L132;
                case 33: goto L130;
                case 34: goto L128;
                case 35: goto L126;
                case 36: goto L124;
                case 37: goto L122;
                case 38: goto L117;
                case 39: goto L115;
                case 40: goto L113;
                case 41: goto L111;
                case 42: goto L109;
                case 43: goto L101;
                case 44: goto L96;
                case 45: goto L88;
                case 46: goto L86;
                case 47: goto L84;
                case 48: goto L82;
                case 49: goto L80;
                case 50: goto L78;
                case 51: goto L76;
                case 52: goto L71;
                case 53: goto L69;
                case 54: goto L67;
                case 55: goto L65;
                case 56: goto L63;
                case 57: goto L61;
                case 58: goto L59;
                case 59: goto L57;
                case 60: goto L52;
                case 61: goto L44;
                case 62: goto L42;
                case 63: goto L40;
                case 64: goto L38;
                case 65: goto L36;
                case 66: goto L34;
                case 67: goto L32;
                case 68: goto L27;
                case 69: goto L19;
                case 70: goto L17;
                case 71: goto L15;
                case 72: goto L13;
                case 73: goto L8;
                default: goto L7;
            };
        L8:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L11;
            r5 = AppEvent.CREATOR.createFromParcel(r17);
        L11:
            boolean r0 = tryActiveAgent(r5);
            r18.writeNoException();
            r18.writeInt(r0 ? 1 : 0);
            return true;
        L13:
            r17.enforceInterface(DESCRIPTOR);
            int r1 = removeEventTaskExecutionDetailRecordsBySessionId(r17.readString());
            r18.writeNoException();
            r18.writeInt(r1);
            return true;
        L15:
            r17.enforceInterface(DESCRIPTOR);
            int r2 = removeEventTaskExecutionDetailRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r2);
            return true;
        L17:
            r17.enforceInterface(DESCRIPTOR);
            int r3 = updateEventTaskExecutionDetailRecords(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r3);
            return true;
        L19:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L22;
            r6 = EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r17);
        L22:
            EventTaskExecutionDetailRecord r20 = updateEventTaskExecutionDetailRecord(r6);
            r18.writeNoException();
            if (r20 == null) goto L25;
            r18.writeInt(1);
            r20.writeToParcel(r18, 1);
        L26:
            return true;
        L25:
            r18.writeInt(0);
            goto L26
        L27:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskExecutionDetailRecord r21 = getEventTaskExecutionDetailRecordById(r17.readLong());
            r18.writeNoException();
            if (r21 == null) goto L30;
            r18.writeInt(1);
            r21.writeToParcel(r18, 1);
        L31:
            return true;
        L30:
            r18.writeInt(0);
            goto L31
        L32:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r22 = getEventTaskExecutionDetailRecordsBySessionId(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r22);
            return true;
        L34:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r23 = getEventTaskExecutionDetailRecords(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r23);
            return true;
        L36:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r24 = addEventTaskExecutionDetailRecords(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r24);
            return true;
        L38:
            r17.enforceInterface(DESCRIPTOR);
            int r25 = removeEventTaskExecutionRecordsByTaskId(r17.readString());
            r18.writeNoException();
            r18.writeInt(r25);
            return true;
        L40:
            r17.enforceInterface(DESCRIPTOR);
            int r26 = removeEventTaskExecutionRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r26);
            return true;
        L42:
            r17.enforceInterface(DESCRIPTOR);
            int r27 = updateEventTaskExecutionRecords(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r27);
            return true;
        L44:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L47;
            r7 = EventTaskExecutionRecord.CREATOR.createFromParcel(r17);
        L47:
            EventTaskExecutionRecord r28 = updateEventTaskExecutionRecord(r7);
            r18.writeNoException();
            if (r28 == null) goto L50;
            r18.writeInt(1);
            r28.writeToParcel(r18, 1);
        L51:
            return true;
        L50:
            r18.writeInt(0);
            goto L51
        L52:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskExecutionRecord r29 = getEventTaskExecutionRecordById(r17.readLong());
            r18.writeNoException();
            if (r29 == null) goto L55;
            r18.writeInt(1);
            r29.writeToParcel(r18, 1);
        L56:
            return true;
        L55:
            r18.writeInt(0);
            goto L56
        L57:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r30 = getEventTaskExecutionRecordsByTaskId(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r30);
            return true;
        L59:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r31 = getEventTaskExecutionRecords(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r31);
            return true;
        L61:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r32 = addEventTaskExecutionRecords(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r32);
            return true;
        L63:
            r17.enforceInterface(DESCRIPTOR);
            int r33 = removeAllEventTaskRecords(r17.readInt());
            r18.writeNoException();
            r18.writeInt(r33);
            return true;
        L65:
            r17.enforceInterface(DESCRIPTOR);
            int r34 = removeEventTaskRecordsById(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r34);
            return true;
        L67:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskRecord> r35 = getAllEventTaskRecords(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r35);
            return true;
        L69:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskRecord> r36 = getEventTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r36);
            return true;
        L71:
            r17.enforceInterface(DESCRIPTOR);
            String r37 = r17.readString();
            ArrayList r38 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            if (r17.readInt() == 0) goto L74;
            r8 = TaskKnowledge.CREATOR.createFromParcel(r17);
        L74:
            tryScheduleConditionTask(r37, r38, r8, r17.readInt(), r17.readString());
            r18.writeNoException();
            return true;
        L76:
            r17.enforceInterface(DESCRIPTOR);
            skipConditionTaskSchedule(r17.readString());
            r18.writeNoException();
            return true;
        L78:
            r17.enforceInterface(DESCRIPTOR);
            scheduleShortcutTask(r17.readString(), r17.readString());
            r18.writeNoException();
            return true;
        L80:
            r17.enforceInterface(DESCRIPTOR);
            List<ShortcutTask> r39 = getShortInstructNotNullShortcutTasks();
            r18.writeNoException();
            r18.writeTypedList(r39);
            return true;
        L82:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r40 = getEventTasksByType(r17.readInt(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r40);
            return true;
        L84:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r41 = getTemplateIdNotNullEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r41);
            return true;
        L86:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r42 = getKnowledgeSessionIdNotNullEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r42);
            return true;
        L88:
            r17.enforceInterface(DESCRIPTOR);
            String r43 = r17.readString();
            if (r17.readInt() == 0) goto L91;
            r9 = EventTaskSpec.CREATOR.createFromParcel(r17);
        L91:
            EventTaskResult r44 = updateEventTask(r43, r9);
            r18.writeNoException();
            if (r44 == null) goto L94;
            r18.writeInt(1);
            r44.writeToParcel(r18, 1);
        L95:
            return true;
        L94:
            r18.writeInt(0);
            goto L95
        L96:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskResult r45 = removeEventTask(r17.createStringArray());
            r18.writeNoException();
            if (r45 == null) goto L99;
            r18.writeInt(1);
            r45.writeToParcel(r18, 1);
        L100:
            return true;
        L99:
            r18.writeInt(0);
            goto L100
        L101:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L104;
            r10 = EventTaskSpec.CREATOR.createFromParcel(r17);
        L104:
            EventTaskResult r46 = addEventTask(r10);
            r18.writeNoException();
            if (r46 == null) goto L107;
            r18.writeInt(1);
            r46.writeToParcel(r18, 1);
        L108:
            return true;
        L107:
            r18.writeInt(0);
            goto L108
        L109:
            r17.enforceInterface(DESCRIPTOR);
            unregisterEventTaskScheduleListener(IEventTaskScheduleListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L111:
            r17.enforceInterface(DESCRIPTOR);
            registerEventTaskScheduleListener(IEventTaskScheduleListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L113:
            r17.enforceInterface(DESCRIPTOR);
            unregisterEventTaskChangeListener(IEventTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L115:
            r17.enforceInterface(DESCRIPTOR);
            registerEventTaskChangeListener(IEventTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L117:
            r17.enforceInterface(DESCRIPTOR);
            EventTask r47 = getEventTask(r17.readString());
            r18.writeNoException();
            if (r47 == null) goto L120;
            r18.writeInt(1);
            r47.writeToParcel(r18, 1);
        L121:
            return true;
        L120:
            r18.writeInt(0);
            goto L121
        L122:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r48 = getAllEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r48);
            return true;
        L124:
            r17.enforceInterface(DESCRIPTOR);
            int r49 = removeAllConditionTaskRecords();
            r18.writeNoException();
            r18.writeInt(r49);
            return true;
        L126:
            r17.enforceInterface(DESCRIPTOR);
            int r50 = removeConditionTaskRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r50);
            return true;
        L128:
            r17.enforceInterface(DESCRIPTOR);
            List<ConditionTaskRecord> r51 = getAllConditionTaskRecords(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r51);
            return true;
        L130:
            r17.enforceInterface(DESCRIPTOR);
            List<ConditionTaskRecord> r52 = getConditionTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r52);
            return true;
        L132:
            r17.enforceInterface(DESCRIPTOR);
            String r53 = r17.readString();
            ArrayList r54 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r55 = r17.readString();
            if (r17.readInt() == 0) goto L135;
            ConditionGroup r56 = ConditionGroup.CREATOR.createFromParcel(r17);
        L137:
            if (r17.readInt() == 0) goto L139;
            PeriodicPolicy r57 = PeriodicPolicy.CREATOR.createFromParcel(r17);
        L141:
            if (r17.readInt() == 0) goto L143;
            TriggerControlPolicy r58 = TriggerControlPolicy.CREATOR.createFromParcel(r17);
        L144:
            ConditionTaskResult r59 = updateConditionTask(r53, r54, r55, r56, r57, r58, r17.readInt(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r59 == null) goto L147;
            r18.writeInt(1);
            r59.writeToParcel(r18, 1);
        L148:
            return true;
        L147:
            r18.writeInt(0);
            goto L148
        L143:
            r58 = null;
            goto L144
        L139:
            r57 = null;
            goto L141
        L135:
            r56 = null;
            goto L137
        L149:
            r17.enforceInterface(DESCRIPTOR);
            ConditionTask r60 = getConditionTask(r17.readString());
            r18.writeNoException();
            if (r60 == null) goto L152;
            r18.writeInt(1);
            r60.writeToParcel(r18, 1);
        L153:
            return true;
        L152:
            r18.writeInt(0);
            goto L153
        L154:
            r17.enforceInterface(DESCRIPTOR);
            ConditionTaskResult r61 = removeConditionTask(r17.createStringArray());
            r18.writeNoException();
            if (r61 == null) goto L157;
            r18.writeInt(1);
            r61.writeToParcel(r18, 1);
        L158:
            return true;
        L157:
            r18.writeInt(0);
            goto L158
        L159:
            r17.enforceInterface(DESCRIPTOR);
            ArrayList r62 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r63 = r17.readString();
            if (r17.readInt() == 0) goto L162;
            ConditionGroup r64 = ConditionGroup.CREATOR.createFromParcel(r17);
        L164:
            if (r17.readInt() == 0) goto L166;
            PeriodicPolicy r65 = PeriodicPolicy.CREATOR.createFromParcel(r17);
        L168:
            if (r17.readInt() == 0) goto L170;
            TriggerControlPolicy r66 = TriggerControlPolicy.CREATOR.createFromParcel(r17);
        L171:
            ConditionTaskResult r67 = addConditionTask(r62, r63, r64, r65, r66, r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r67 == null) goto L174;
            r18.writeInt(1);
            r67.writeToParcel(r18, 1);
        L175:
            return true;
        L174:
            r18.writeInt(0);
            goto L175
        L170:
            r66 = null;
            goto L171
        L166:
            r65 = null;
            goto L168
        L162:
            r64 = null;
            goto L164
        L176:
            r17.enforceInterface(DESCRIPTOR);
            unRegisterAssistantSessionState(IAssistantSessionStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L178:
            r17.enforceInterface(DESCRIPTOR);
            registerAssistantSessionState(IAssistantSessionStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L180:
            r17.enforceInterface(DESCRIPTOR);
            unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L182:
            r17.enforceInterface(DESCRIPTOR);
            registerAssistantTtsPlayingState(IAssistantTtsStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L184:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L187;
            r11 = AppEvent.CREATOR.createFromParcel(r17);
        L187:
            boolean r68 = tryOpenMicToRecording(r11);
            r18.writeNoException();
            r18.writeInt(r68 ? 1 : 0);
            return true;
        L189:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L192;
            r12 = AppEvent.CREATOR.createFromParcel(r17);
        L192:
            boolean r69 = tryInterruptAssistant(r12);
            r18.writeNoException();
            r18.writeInt(r69 ? 1 : 0);
            return true;
        L194:
            r17.enforceInterface(DESCRIPTOR);
            int r70 = getAssistantTtsPlayingState();
            r18.writeNoException();
            r18.writeInt(r70);
            return true;
        L196:
            r17.enforceInterface(DESCRIPTOR);
            int r71 = getAssistantSessionState();
            r18.writeNoException();
            r18.writeInt(r71);
            return true;
        L198:
            r17.enforceInterface(DESCRIPTOR);
            requestSendMessage(r17.readString(), r17.readString(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            return true;
        L200:
            r17.enforceInterface(DESCRIPTOR);
            setAssistantInteractionListener(IAssistantInteractionListener.Stub.asInterface(r17.readStrongBinder()));
            r18.writeNoException();
            return true;
        L202:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L206;
            r110 = true;
        L206:
            if (r17.readInt() == 0) goto L208;
            StateInfo.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            r13 = new StateInfo(r17);
        L208:
            notifyAssistantState(r110, r13);
            r18.writeNoException();
            return true;
        L210:
            r17.enforceInterface(DESCRIPTOR);
            closeAssistantInputPanel();
            r18.writeNoException();
            return true;
        L212:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L216;
            StateInfo.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            r14 = new StateInfo(r17);
        L216:
            if (r17.readInt() == 0) goto L218;
            r110 = true;
        L218:
            openAssistantInputPanel(r14, r110);
            r18.writeNoException();
            return true;
        L220:
            r17.enforceInterface(DESCRIPTOR);
            unregisterTimerTaskChangeListener(ITimerTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L222:
            r17.enforceInterface(DESCRIPTOR);
            registerTimerTaskChangeListener(ITimerTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L224:
            r17.enforceInterface(DESCRIPTOR);
            int r72 = removeAllTimeTaskRecords();
            r18.writeNoException();
            r18.writeInt(r72);
            return true;
        L226:
            r17.enforceInterface(DESCRIPTOR);
            int r73 = removeTimerTaskRecordsById(r17.createIntArray());
            r18.writeNoException();
            r18.writeInt(r73);
            return true;
        L228:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTaskRecord> r74 = getAllTimerTaskRecords(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r74);
            return true;
        L230:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTaskRecord> r75 = getTimerTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r75);
            return true;
        L232:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTask> r76 = getAllTimerTasks();
            r18.writeNoException();
            r18.writeTypedList(r76);
            return true;
        L234:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTask> r77 = getTimerTask(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            r18.writeTypedList(r77);
            return true;
        L236:
            r17.enforceInterface(DESCRIPTOR);
            long r78 = getNextScheduleTimeStamp(r17.readInt());
            r18.writeNoException();
            r18.writeLong(r78);
            return true;
        L238:
            r17.enforceInterface(DESCRIPTOR);
            TimerTask r79 = getTimerTaskByTaskId(r17.readInt());
            r18.writeNoException();
            if (r79 == null) goto L241;
            r18.writeInt(1);
            r79.writeToParcel(r18, 1);
        L242:
            return true;
        L241:
            r18.writeInt(0);
            goto L242
        L243:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L246;
            TimerTask.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            r15 = new TimerTask(r17);
        L246:
            TimerTaskResult r80 = updateTimerTask(r15);
            r18.writeNoException();
            if (r80 == null) goto L249;
            r18.writeInt(1);
            r80.writeToParcel(r18, 1);
        L250:
            return true;
        L249:
            r18.writeInt(0);
            goto L250
        L251:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r81 = skipTimerTasksByTaskId(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            if (r81 == null) goto L254;
            r18.writeInt(1);
            r81.writeToParcel(r18, 1);
        L255:
            return true;
        L254:
            r18.writeInt(0);
            goto L255
        L256:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r82 = removeTimerTask(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r82 == null) goto L259;
            r18.writeInt(1);
            r82.writeToParcel(r18, 1);
        L260:
            return true;
        L259:
            r18.writeInt(0);
            goto L260
        L261:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r83 = removeTimerTasksByTaskId(r17.createIntArray());
            r18.writeNoException();
            if (r83 == null) goto L264;
            r18.writeInt(1);
            r83.writeToParcel(r18, 1);
        L265:
            return true;
        L264:
            r18.writeInt(0);
            goto L265
        L266:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L269;
            TimerTask.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            r4 = new TimerTask(r17);
        L269:
            TimerTaskResult r84 = addTimerTask(r4);
            r18.writeNoException();
            if (r84 == null) goto L272;
            r18.writeInt(1);
            r84.writeToParcel(r18, 1);
        L273:
            return true;
        L272:
            r18.writeInt(0);
            goto L273
        L7:
            return super.onTransact(r16, r17, r18, r19);
        L274:
            r18.writeString(DESCRIPTOR);
            return true;
        }
    }

    ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map r6);

    EventTaskResult addEventTask(EventTaskSpec r1);

    List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult addTimerTask(TimerTask r1);

    void closeAssistantInputPanel();

    List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3);

    List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5);

    List<EventTask> getAllEventTasks();

    List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3);

    List<TimerTask> getAllTimerTasks();

    int getAssistantSessionState();

    int getAssistantTtsPlayingState();

    ConditionTask getConditionTask(String r1);

    List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5);

    EventTask getEventTask(String r1);

    EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r1, int r2, int r3);

    EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3);

    List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5);

    List<EventTask> getEventTasksByType(int r1, int r2, int r3);

    List<EventTask> getKnowledgeSessionIdNotNullEventTasks();

    long getNextScheduleTimeStamp(int r1);

    List<ShortcutTask> getShortInstructNotNullShortcutTasks();

    List<EventTask> getTemplateIdNotNullEventTasks();

    List<TimerTask> getTimerTask(Map r1);

    TimerTask getTimerTaskByTaskId(int r1);

    List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, int r5);

    void notifyAssistantState(boolean r1, StateInfo r2);

    void openAssistantInputPanel(StateInfo r1, boolean r2);

    void registerAssistantSessionState(IAssistantSessionStateListener r1);

    void registerAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void registerEventTaskChangeListener(IEventTaskChangeListener r1);

    void registerEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void registerTimerTaskChangeListener(ITimerTaskChangeListener r1);

    int removeAllConditionTaskRecords();

    int removeAllEventTaskRecords(int r1);

    int removeAllTimeTaskRecords();

    ConditionTaskResult removeConditionTask(String[] r1);

    int removeConditionTaskRecordsById(long[] r1);

    EventTaskResult removeEventTask(String[] r1);

    int removeEventTaskExecutionDetailRecordsById(long[] r1);

    int removeEventTaskExecutionDetailRecordsBySessionId(String r1);

    int removeEventTaskExecutionRecordsById(long[] r1);

    int removeEventTaskExecutionRecordsByTaskId(String r1);

    int removeEventTaskRecordsById(int r1, long[] r2);

    TimerTaskResult removeTimerTask(Map r1);

    int removeTimerTaskRecordsById(int[] r1);

    TimerTaskResult removeTimerTasksByTaskId(int[] r1);

    void requestSendMessage(String r1, String r2, Map r3);

    void scheduleShortcutTask(String r1, String r2);

    void setAssistantInteractionListener(IAssistantInteractionListener r1);

    void skipConditionTaskSchedule(String r1);

    TimerTaskResult skipTimerTasksByTaskId(int r1, long[] r2);

    boolean tryActiveAgent(AppEvent r1);

    boolean tryInterruptAssistant(AppEvent r1);

    boolean tryOpenMicToRecording(AppEvent r1);

    void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5);

    void unRegisterAssistantSessionState(IAssistantSessionStateListener r1);

    void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void unregisterEventTaskChangeListener(IEventTaskChangeListener r1);

    void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r1);

    ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map r8);

    EventTaskResult updateEventTask(String r1, EventTaskSpec r2);

    EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1);

    int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1);

    int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult updateTimerTask(TimerTask r1);
}
