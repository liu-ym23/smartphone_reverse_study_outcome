package com.obric.eventkit.eventstaskmanager;

import android.os.IBinder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ITaskManager$Default implements ITaskManager {
    public ITaskManager$Default() {
    }

    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map r6) {
        return null;
    }

    public EventTaskResult addEventTask(EventTaskSpec r1) {
        return null;
    }

    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1) {
        return null;
    }

    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1) {
        return null;
    }

    public TimerTaskResult addTimerTask(TimerTask r1) {
        return null;
    }

    public IBinder asBinder() {
        return null;
    }

    public void closeAssistantInputPanel() {
    }

    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
        return null;
    }

    public List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5) {
        return null;
    }

    public List<EventTask> getAllEventTasks() {
        return null;
    }

    public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
        return null;
    }

    public List<TimerTask> getAllTimerTasks() {
        return null;
    }

    public int getAssistantSessionState() {
        return 0;
    }

    public int getAssistantTtsPlayingState() {
        return 0;
    }

    public ConditionTask getConditionTask(String r1) {
        return null;
    }

    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5) {
        return null;
    }

    public EventTask getEventTask(String r1) {
        return null;
    }

    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
        return null;
    }

    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
        return null;
    }

    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r1, int r2, int r3) {
        return null;
    }

    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
        return null;
    }

    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
        return null;
    }

    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3) {
        return null;
    }

    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5) {
        return null;
    }

    public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
        return null;
    }

    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        return null;
    }

    public long getNextScheduleTimeStamp(int r3) {
        return 0;
    }

    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        return null;
    }

    public List<EventTask> getTemplateIdNotNullEventTasks() {
        return null;
    }

    public List<TimerTask> getTimerTask(Map r1) {
        return null;
    }

    public TimerTask getTimerTaskByTaskId(int r1) {
        return null;
    }

    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, int r5) {
        return null;
    }

    public void notifyAssistantState(boolean r1, StateInfo r2) {
    }

    public void openAssistantInputPanel(StateInfo r1, boolean r2) {
    }

    public void registerAssistantSessionState(IAssistantSessionStateListener r1) {
    }

    public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r1) {
    }

    public void registerEventTaskChangeListener(IEventTaskChangeListener r1) {
    }

    public void registerEventTaskScheduleListener(IEventTaskScheduleListener r1) {
    }

    public void registerTimerTaskChangeListener(ITimerTaskChangeListener r1) {
    }

    public int removeAllConditionTaskRecords() {
        return 0;
    }

    public int removeAllEventTaskRecords(int r1) {
        return 0;
    }

    public int removeAllTimeTaskRecords() {
        return 0;
    }

    public ConditionTaskResult removeConditionTask(String[] r1) {
        return null;
    }

    public int removeConditionTaskRecordsById(long[] r1) {
        return 0;
    }

    public EventTaskResult removeEventTask(String[] r1) {
        return null;
    }

    public int removeEventTaskExecutionDetailRecordsById(long[] r1) {
        return 0;
    }

    public int removeEventTaskExecutionDetailRecordsBySessionId(String r1) {
        return 0;
    }

    public int removeEventTaskExecutionRecordsById(long[] r1) {
        return 0;
    }

    public int removeEventTaskExecutionRecordsByTaskId(String r1) {
        return 0;
    }

    public int removeEventTaskRecordsById(int r1, long[] r2) {
        return 0;
    }

    public TimerTaskResult removeTimerTask(Map r1) {
        return null;
    }

    public int removeTimerTaskRecordsById(int[] r1) {
        return 0;
    }

    public TimerTaskResult removeTimerTasksByTaskId(int[] r1) {
        return null;
    }

    public void requestSendMessage(String r1, String r2, Map r3) {
    }

    public void scheduleShortcutTask(String r1, String r2) {
    }

    public void setAssistantInteractionListener(IAssistantInteractionListener r1) {
    }

    public void skipConditionTaskSchedule(String r1) {
    }

    public TimerTaskResult skipTimerTasksByTaskId(int r1, long[] r2) {
        return null;
    }

    public boolean tryActiveAgent(AppEvent r1) {
        return false;
    }

    public boolean tryInterruptAssistant(AppEvent r1) {
        return false;
    }

    public boolean tryOpenMicToRecording(AppEvent r1) {
        return false;
    }

    public void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5) {
    }

    public void unRegisterAssistantSessionState(IAssistantSessionStateListener r1) {
    }

    public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r1) {
    }

    public void unregisterEventTaskChangeListener(IEventTaskChangeListener r1) {
    }

    public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r1) {
    }

    public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r1) {
    }

    public ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map r8) {
        return null;
    }

    public EventTaskResult updateEventTask(String r1, EventTaskSpec r2) {
        return null;
    }

    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1) {
        return null;
    }

    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1) {
        return 0;
    }

    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1) {
        return null;
    }

    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1) {
        return 0;
    }

    public TimerTaskResult updateTimerTask(TimerTask r1) {
        return null;
    }
}
